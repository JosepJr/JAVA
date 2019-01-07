/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandeditar;

import command.ICommandManterOS;
import javax.swing.JOptionPane;
import model.NivelServico;
import model.OrdemServico;
import presenter.BuscarOrdemServicoPresenter;
import presenter.ManterOrdemServicoPresenter;
import presenter.TabelaManterOSPresenter;
import statevisualizar.VisualizarNiveisServicosState;
import statevisualizar.VisualizarNivelServicoState;
import test.DadosTeste;

/**
 *
 * @author Josep
 */
public class EditarNivelServicoCommand implements ICommandManterOS {

    private static EditarNivelServicoCommand instance;

    private EditarNivelServicoCommand() {

    }

    public static EditarNivelServicoCommand getInstance() {
        if (instance == null) {
            instance = new EditarNivelServicoCommand();
        }
        return instance;
    }

    @Override
    public void executar(ManterOrdemServicoPresenter presenter, OrdemServico os, Object ob1, Object ob2) {

        NivelServico nivelServico = (NivelServico) ob1;

        presenter.getView().getjButtonCancelar().addActionListener((e) -> {
            if (presenter.setJanelaConfirmacao("Deseja mesmo cancelar a edição deste Nivel de Serviço?") == 0) {
                presenter.setState(new VisualizarNivelServicoState(presenter));
                presenter.visualizar(os, nivelServico, ob2);
            }
        });

        presenter.getView().getjButtonAvancar().addActionListener((e) -> {
            try {
                DadosTeste.getInstance().getOrdensServico().remove(os);
                os.getNivelMinimoServico().getNiveisServicos().remove(nivelServico);

                nivelServico.setIndicador(presenter.getView().getJTextField1().getText());
                nivelServico.setResultado(Integer.parseInt(presenter.getView().getJTextField2().getText()));
                nivelServico.setRedutor(Double.parseDouble(presenter.getView().getJTextField3().getText()));
                nivelServico.setValorReducao(Double.parseDouble(presenter.getView().getJTextField4().getText()));

                this.realizarUpdate(presenter, os, nivelServico);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });

    }

    @Override
    public void desfazer() {
    }

    private void realizarUpdate(ManterOrdemServicoPresenter presenter, OrdemServico os, NivelServico nivelServico) {
        try {

            os.getNivelMinimoServico().getNiveisServicos().add(nivelServico);

            DadosTeste.getInstance().addOrdemServico(os);

            BuscarOrdemServicoPresenter.getInstance().preencherTabela();

            TabelaManterOSPresenter presenter2 = TabelaManterOSPresenter.getInstance();

            presenter2.setState(new VisualizarNiveisServicosState(presenter2));
            presenter2.visualizar(null, os);

            presenter.setState(new VisualizarNivelServicoState(presenter));
            presenter.visualizar(os, nivelServico, null);

            JOptionPane.showMessageDialog(null, "Registro Nivel de Servico selecionado atualizado com sucesso!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }
}
