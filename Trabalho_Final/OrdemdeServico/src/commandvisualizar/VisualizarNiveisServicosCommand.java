/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandvisualizar;

import command.ICommandTabela;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.NivelServico;
import model.OrdemServico;
import presenter.BuscarOrdemServicoPresenter;
import presenter.ManterOrdemServicoPresenter;
import presenter.TabelaManterOSPresenter;
import presenter.TelaPrincipalPresenter;
import statevisualizar.VisualizarNiveisServicosState;
import statevisualizar.VisualizarNivelServicoState;
import test.DadosTeste;

/**
 *
 * @author Josep
 */
public class VisualizarNiveisServicosCommand implements ICommandTabela {

    private static VisualizarNiveisServicosCommand instance;

    public static VisualizarNiveisServicosCommand getInstance() {
        if (instance == null) {
            instance = new VisualizarNiveisServicosCommand();
        }
        return instance;
    }

    @Override
    public void executar(TabelaManterOSPresenter presenter, Object o, OrdemServico os) {

        ArrayList<NivelServico> nivelServicos = os.getNivelMinimoServico().getNiveisServicos();

        presenter.getView().getjButtonVisualizar().addActionListener((e1) -> {
            if (presenter.getView().getjTable().getSelectedColumn() == 0) {
                for (NivelServico nivelservico : nivelServicos) {
                    try {
                        if (presenter.getView().getjTable().getValueAt(presenter.getView().getjTable().getSelectedRow(), 0).equals(nivelservico.getIndicador())) {
                            ManterOrdemServicoPresenter presenter2 = ManterOrdemServicoPresenter.getInstance();
                            TelaPrincipalPresenter.getInstance().getView().getjDesktopPanePrincipal().add(presenter2.getView());
                            presenter2.setState(new VisualizarNivelServicoState(presenter2));
                            presenter2.visualizar(os, nivelservico, null);
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
                    if (presenter.setJanelaConfirmacao("Deseja mesmo Excluir este Nivel de Serviço?") == 0) {
                        for (NivelServico nivelservico : nivelServicos) {
                            try {
                                if (presenter.getView().getjTable().getValueAt(presenter.getView().getjTable().getSelectedRow(), 0).equals(nivelservico.getIndicador())) {
                                    DadosTeste.getInstance().getOrdensServico().remove(os);
                                    os.getNivelMinimoServico().getNiveisServicos().remove(nivelservico);
                                    this.realizarUpdate(presenter, os);
                                }
                            } catch (Exception ex) {
                                //Tratar essa exception pois ela esta dando um erro que eu não sei qual é
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Não é possível Realizar a exclusão deste Nivel de Serviço pois ele é unico!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Favor selecionar um indicador para a exclusão!");
            }
        });

        presenter.getView().getjButtonAvancar().addActionListener((e) -> {
            JOptionPane.showMessageDialog(null, "Edição da Ordem de Servico concluida!\nNão há mais edições a serem feitas.");
            presenter.fecharView();
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

            presenter2.setState(new VisualizarNiveisServicosState(presenter2));
            presenter2.visualizar(null, os);

            JOptionPane.showMessageDialog(null, "Nivel Servico selecionado removido com sucesso!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

}
