/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandeditar;

import command.ICommandManterOS;
import javax.swing.JOptionPane;
import model.OrdemServico;
import presenter.BuscarOrdemServicoPresenter;
import presenter.ManterOrdemServicoPresenter;
import statevisualizar.VisualizarOrdemServicoState;
import test.DadosTeste;

/**
 *
 * @author Josep
 */
public class EditarOrdemServicoCommand implements ICommandManterOS {

    private static EditarOrdemServicoCommand instance;

    private EditarOrdemServicoCommand() {

    }

    public static EditarOrdemServicoCommand getInstance() {
        if (instance == null) {
            instance = new EditarOrdemServicoCommand();
        }
        return instance;
    }

    @Override
    public void executar(ManterOrdemServicoPresenter presenter, OrdemServico os, Object ob1, Object ob2) {

        presenter.getView().getjButtonCancelar().addActionListener((e2) -> {
            if (presenter.setJanelaConfirmacao("Deseja realmente cancelar esta edição?") == 0) {
                presenter.setState(new VisualizarOrdemServicoState(presenter));
                presenter.visualizar(os, null, null);
            }
        });

        presenter.getView().getjButtonEditar().addActionListener((e2) -> {
            this.atualizarOS(presenter, os, null, null);
        });

    }

    @Override
    public void desfazer() {

    }

    private void atualizarOS(ManterOrdemServicoPresenter presenter, OrdemServico os, Object ob1, Object ob2) {
        try {
            DadosTeste.getInstance().getOrdensServico().remove(os);

            os.setNumero(Integer.parseInt(presenter.getView().getJTextField1().getText()));
            os.setDataEmissao(presenter.getView().getJTextField2().getText());
            os.setNomeFiscalEmissor(presenter.getView().getJTextField3().getText());

            DadosTeste.getInstance().addOrdemServico(os);

            BuscarOrdemServicoPresenter.getInstance().preencherTabela();

            JOptionPane.showMessageDialog(null, "Situacao da Ordem de Servico Atualizada com sucesso!");

            presenter.setState(new VisualizarOrdemServicoState(presenter));
            presenter.visualizar(os, null, null);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

}
