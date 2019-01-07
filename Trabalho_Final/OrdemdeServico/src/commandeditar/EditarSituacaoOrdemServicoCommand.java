/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandeditar;

import command.ICommandManterOS;
import javax.swing.JOptionPane;
import model.OrdemServico;
import model.Situacao;
import presenter.BuscarOrdemServicoPresenter;
import presenter.ManterOrdemServicoPresenter;
import statevisualizar.VisualizarSituacaoOrdemServicoState;
import test.DadosTeste;

/**
 *
 * @author Josep
 */
public class EditarSituacaoOrdemServicoCommand implements ICommandManterOS {

    private static EditarSituacaoOrdemServicoCommand instance;

    private EditarSituacaoOrdemServicoCommand() {

    }

    public static EditarSituacaoOrdemServicoCommand getInstance() {
        if (instance == null) {
            instance = new EditarSituacaoOrdemServicoCommand();
        }
        return instance;
    }

    @Override
    public void executar(ManterOrdemServicoPresenter presenter, OrdemServico os, Object ob1, Object ob2) {

        presenter.getView().getjButtonCancelar().addActionListener((e1) -> {
            if (presenter.setJanelaConfirmacao("Deseja realmente cancelar?") == 0) {
                presenter.visualizar(os, null, null);
            }
        });

        presenter.getView().getjButtonEditar().addActionListener((e1) -> {
            this.atualizarOS(presenter, os, ob1, null);
        });

    }

    @Override
    public void desfazer() {
    }

    private void atualizarOS(ManterOrdemServicoPresenter presenter, OrdemServico os, Object ob1, Object ob2) {
        try {
            Situacao situacao = new Situacao(
                    presenter.getView().getjComboBoxSituacao().getSelectedItem().toString(),
                    presenter.getView().getJTextField1().getText(),
                    presenter.getView().getJTextField2().getText(),
                    presenter.getView().getJTextField3().getText());
            os.addSituacao(situacao);
            JOptionPane.showMessageDialog(null, "Situação da Ordem de Serviço atualizada com sucesso!");

            DadosTeste.getInstance().getOrdensServico().remove(os);
            DadosTeste.getInstance().addOrdemServico(os);

            BuscarOrdemServicoPresenter.getInstance().preencherTabela();

            presenter.setState(new VisualizarSituacaoOrdemServicoState(presenter));
            presenter.visualizar(os, null, null);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }
}
