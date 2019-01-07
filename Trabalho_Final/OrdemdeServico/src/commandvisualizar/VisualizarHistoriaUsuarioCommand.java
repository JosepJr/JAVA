/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandvisualizar;

import command.ICommandTabela;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import model.DisciplinaHistoriaUsuario;
import model.HistoriaUsuario;
import model.OrdemServico;
import presenter.BuscarOrdemServicoPresenter;
import presenter.ManterOrdemServicoPresenter;
import presenter.TabelaManterOSPresenter;
import presenter.TelaPrincipalPresenter;
import stateeditar.EditarHistoriaSelecionadaState;
import statevisualizar.VisualizarDisciplinaHistoriaUsuarioState;
import statevisualizar.VisualizarHistoriaUsuarioState;
import statevisualizar.VisualizarHistoriasUsuarioState;
import test.DadosTeste;

/**
 *
 * @author Josep
 */
public class VisualizarHistoriaUsuarioCommand implements ICommandTabela {

    private static VisualizarHistoriaUsuarioCommand instance;

    private VisualizarHistoriaUsuarioCommand() {

    }

    public static VisualizarHistoriaUsuarioCommand getInstance() {
        if (instance == null) {
            instance = new VisualizarHistoriaUsuarioCommand();
        }
        return instance;
    }

    @Override
    public void executar(TabelaManterOSPresenter presenter, Object ob1, OrdemServico os) {

        HistoriaUsuario historia = (HistoriaUsuario) ob1;

        presenter.getView().getjButtonEditar().addActionListener((el) -> {
            presenter.setState(new EditarHistoriaSelecionadaState(presenter));
            presenter.editar(historia, os);
        });

        presenter.getView().getjButtonCancelar().addActionListener((e1) -> {
            if (presenter.setJanelaConfirmacao("Deseja realmente sair da edição desta história de usuário?\n Atualizações já feitas serão mantidas.") == 0) {
                presenter.getView().getjButtonAvancar().setText("Avancar");
                presenter.setState(new VisualizarHistoriasUsuarioState(presenter));
                presenter.visualizar(historia, os);
            }
        });

        presenter.getView().getjButtonVisualizar().addActionListener((ActionEvent e) -> {
            if (presenter.getView().getjTable().getSelectedColumn() == 0) {
                for (DisciplinaHistoriaUsuario disciplina : historia.getDisciplinas()) {
                    try {
                        if (presenter.getView().getjTable().getValueAt(presenter.getView().getjTable().getSelectedRow(), 0).equals(disciplina.getDescricao())) {

                            ManterOrdemServicoPresenter presenter2 = ManterOrdemServicoPresenter.getInstance();
                            TelaPrincipalPresenter.getInstance().getView().getjDesktopPanePrincipal().add(presenter2.getView());

                            presenter2.setState(new VisualizarDisciplinaHistoriaUsuarioState(presenter2));
                            presenter2.visualizar(os, disciplina, historia);
                        }
                    } catch (Exception ex) {
                        //Tratar essa exception pois ela esta dando um erro que eu não sei qual é
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Favor selecionar a disciplina para a visualização!");
            }
        });

        presenter.getView().getjButtonAvancar().addActionListener((e) -> {
            if (presenter.getView().getjTable().getSelectedColumn() == 0) {
                if (presenter.getView().getjTable().getRowCount() > 1) {
                    for (DisciplinaHistoriaUsuario disciplina : historia.getDisciplinas()) {
                        this.atualizarInformacoesOS(presenter, os, disciplina, historia);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Não é possível Realizar a exclusão desta disciplina pois ela é unica!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Favor selecionar uma diciplina para a exclusão!");
            }
        });

    }

    @Override
    public void desfazer() {
    }

    private void atualizarInformacoesOS(TabelaManterOSPresenter presenter, OrdemServico os, DisciplinaHistoriaUsuario disciplina, HistoriaUsuario historia) {
        try {
            if (presenter.getView().getjTable().getValueAt(presenter.getView().getjTable().getSelectedRow(), 0).equals(disciplina.getDescricao())) {
                if (presenter.setJanelaConfirmacao("Deseja mesmo excluir a disciplina selecionada?") == 0) {

                    DadosTeste.getInstance().getOrdensServico().remove(os);
                    historia.getDisciplinas().remove(disciplina);
                    this.realizarUpdate(presenter, os, disciplina, historia);
                }
            }
        } catch (Exception ex) {
            //Tratar essa exception pois ela esta dando um erro que eu não sei qual é
        }
    }

    private void realizarUpdate(TabelaManterOSPresenter presenter, OrdemServico os, DisciplinaHistoriaUsuario disciplina, HistoriaUsuario historia) {
        try {
            DadosTeste.getInstance().addOrdemServico(os);
            BuscarOrdemServicoPresenter.getInstance().preencherTabela();

            TabelaManterOSPresenter presenter2 = TabelaManterOSPresenter.getInstance();

            presenter2.setState(new VisualizarHistoriasUsuarioState(presenter2));
            presenter2.visualizar(null, os);

            presenter2.setState(new VisualizarHistoriaUsuarioState(presenter2));
            presenter2.visualizar(historia, os);


            JOptionPane.showMessageDialog(null, "Disciplina de historia de usuário atualizada com sucesso!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }
}
