/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandvisualizar;

import command.ICommandTabela;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.CriterioGeralNMS;
import model.OrdemServico;
import presenter.BuscarOrdemServicoPresenter;
import presenter.ManterOrdemServicoPresenter;
import presenter.TabelaManterOSPresenter;
import presenter.TelaPrincipalPresenter;
import statevisualizar.VisualizarCriterioGeralNMSState;
import statevisualizar.VisualizarCriteriosGeraisNMSState;
import statevisualizar.VisualizarNiveisServicosState;
import test.DadosTeste;

/**
 *
 * @author Josep
 */
public class VisualizarCriteriosGeraisNMSCommand implements ICommandTabela {

    private static VisualizarCriteriosGeraisNMSCommand instance;

    public static VisualizarCriteriosGeraisNMSCommand getInstance() {
        if (instance == null) {
            instance = new VisualizarCriteriosGeraisNMSCommand();
        }
        return instance;
    }

    @Override
    public void executar(TabelaManterOSPresenter presenter, Object ob1, OrdemServico os) {

        ArrayList<CriterioGeralNMS> criterios = os.getNivelMinimoServico().getCriteriosGerais();

        presenter.getView().getjButtonVisualizar().addActionListener((e1) -> {
            if (presenter.getView().getjTable().getSelectedColumn() == 0) {
                for (CriterioGeralNMS criterio : criterios) {
                    try {
                        if (presenter.getView().getjTable().getValueAt(presenter.getView().getjTable().getSelectedRow(), 0).equals(criterio.getCriterio())) {
                            ManterOrdemServicoPresenter.getInstance().fecharView();
                            ManterOrdemServicoPresenter presenter2 = ManterOrdemServicoPresenter.getInstance();
                            TelaPrincipalPresenter.getInstance().getView().getjDesktopPanePrincipal().add(presenter2.getView());
                            presenter2.setState(new VisualizarCriterioGeralNMSState(presenter2));
                            presenter2.visualizar(os, criterio, null);
                        }
                    } catch (Exception ex) {

                        //Tratar essa exception pois ela esta dando um erro que eu não sei qual é
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Favor selecionar somente o Critério para a visualização!");
            }
        });

        presenter.getView().getjButtonCancelar().addActionListener((e1) -> {
            if (presenter.setJanelaConfirmacao("Deseja realmente sair? \n A janela será fechada e o restante da edição não será realizada.\n Atualizações já feitas serão mantidas.") == 0) {
                presenter.fecharView();
                ManterOrdemServicoPresenter.getInstance().fecharView();
            }
        });

        presenter.getView().getjButtonEditar().addActionListener((e) -> {
            if (presenter.getView().getjTable().getSelectedColumn() == 0) {
                if (presenter.getView().getjTable().getRowCount() > 1) {
                    if (presenter.setJanelaConfirmacao("Deseja  mesmo Excluir este critério? ") == 0) {
                        for (CriterioGeralNMS criterio : criterios) {
                            try {
                                if (presenter.getView().getjTable().getValueAt(presenter.getView().getjTable().getSelectedRow(), 0).equals(criterio.getCriterio())) {
                                    DadosTeste.getInstance().getOrdensServico().remove(os);
                                    os.getNivelMinimoServico().getCriteriosGerais().remove(criterio);
                                    this.realizarUpdate(presenter, os);
                                }
                            } catch (Exception ex) {
                                //Tratar essa exception pois ela esta dando um erro que eu não sei qual é
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Não é possível Realizar a exclusão deste critério pois ele é unico!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Favor selecionar um critério para a exclusão!");
            }
        });

        presenter.getView().getjButtonAvancar().addActionListener((e) -> {
            if (presenter.setJanelaConfirmacao("Deseja seguir para Niveis de Serviço?") == 0) {
                presenter.setState(new VisualizarNiveisServicosState(presenter));
                presenter.visualizar(null, os);
            }
        });

    }

    @Override
    public void desfazer() {
    }


    private void realizarUpdate(TabelaManterOSPresenter presenter, OrdemServico os) {
        try {
            DadosTeste.getInstance().addOrdemServico(os);
            BuscarOrdemServicoPresenter.getInstance().preencherTabela();

            TabelaManterOSPresenter presenter2 = TabelaManterOSPresenter.getInstance();

            presenter2.setState(new VisualizarCriteriosGeraisNMSState(presenter2));
            presenter2.visualizar(null, os);

            JOptionPane.showMessageDialog(null, "Criterio geral selecionado removido com sucesso!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

}
