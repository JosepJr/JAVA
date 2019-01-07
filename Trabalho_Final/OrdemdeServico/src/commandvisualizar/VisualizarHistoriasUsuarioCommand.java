/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandvisualizar;

import command.ICommandTabela;
import javax.swing.JOptionPane;
import model.HistoriaUsuario;
import model.OrdemServico;
import presenter.BuscarOrdemServicoPresenter;
import presenter.ManterOrdemServicoPresenter;
import presenter.TabelaManterOSPresenter;
import presenter.TelaPrincipalPresenter;
import statevisualizar.VisualizarCriteriosGeraisNMSState;
import statevisualizar.VisualizarHistoriaUsuarioState;
import statevisualizar.VisualizarHistoriasUsuarioState;
import test.DadosTeste;

/**
 *
 * @author Josep
 */
public class VisualizarHistoriasUsuarioCommand implements ICommandTabela {

    private static VisualizarHistoriasUsuarioCommand instance;

    public static VisualizarHistoriasUsuarioCommand getInstance() {
        if (instance == null) {
            instance = new VisualizarHistoriasUsuarioCommand();
        }
        return instance;
    }

    @Override
    public void executar(TabelaManterOSPresenter presenter, Object ob1, OrdemServico os) {

        presenter.getView().getjButtonVisualizar().addActionListener((e1) -> {
            if (presenter.getView().getjTable().getSelectedColumn() == 0) {
                for (HistoriaUsuario historia : os.getHistoriasUsuarios()) {
                    try {
                        if (presenter.getView().getjTable().getValueAt(presenter.getView().getjTable().getSelectedRow(), 0).equals(historia.getNome())) {
                            presenter.setState(new VisualizarHistoriaUsuarioState(presenter));
                            presenter.visualizar(historia, os);
                        }
                    } catch (Exception ex) {
                        //Tratar essa exception pois ela esta dando um erro que eu não sei qual é
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Favor selecionar somente o nome da História de Usuário para visualização!");
            }
        });

        presenter.getView().getjButtonCancelar().addActionListener((e1) -> {
            if (presenter.setJanelaConfirmacao("Deseja realmente sair? \n A janela será fechada e o restante da edição da Ordem de Serviço(OS) não será realizada.\n Atualizações já feitas serão mantidas.") == 0) {
                presenter.fecharView();
                ManterOrdemServicoPresenter.getInstance().fecharView();
            }
        });

        presenter.getView().getjButtonEditar().addActionListener((e1) -> {
            this.excluirHistoria(presenter, os);
        });

        presenter.getView().getjButtonAvancar().addActionListener((e1) -> {
            if (presenter.setJanelaConfirmacao("Deseja seguir para Registro de Níveis Minimos de Serviço?") == 0) {
                presenter.setState(new VisualizarCriteriosGeraisNMSState(presenter));
                presenter.visualizar(null, os);
            }
        });
    }

    @Override
    public void desfazer() {
    }

    private void excluirHistoria(TabelaManterOSPresenter presenter, OrdemServico os) {
        if (presenter.getView().getjTable().getSelectedColumn() == 0) {
            if (presenter.getView().getjTable().getRowCount() > 1) {
                for (HistoriaUsuario historia : os.getHistoriasUsuarios()) {
                    try {
                        if (presenter.getView().getjTable().getValueAt(presenter.getView().getjTable().getSelectedRow(), 0).equals(historia.getNome())) {
                            if (presenter.setJanelaConfirmacao("Deseja  mesmo Excluir essa História de Usuário com todas as suas Disciplinas?") == 0) {
                                this.realizarUpdate(presenter, os, historia);
                            }
                        }
                    } catch (Exception ex) {
                        //Tratar essa exception pois ela esta dando um erro que eu não sei qual é
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não é possível Realizar a exclusão desta História pois ela é unica!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Favor selecionar o nome de História de Usuário para a exclusão!");
        }

    }

    private void realizarUpdate(TabelaManterOSPresenter presenter, OrdemServico os, HistoriaUsuario historia) {
        try {
            DadosTeste.getInstance().getOrdensServico().remove(os);

            os.getHistoriasUsuarios().remove(historia);
            DadosTeste.getInstance().addOrdemServico(os);

            BuscarOrdemServicoPresenter.getInstance().preencherTabela();

            presenter.setState(new VisualizarHistoriasUsuarioState(presenter));
            presenter.visualizar(null, os);

            JOptionPane.showMessageDialog(null, "Ordem de Servico Atualizada com sucesso!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

}
