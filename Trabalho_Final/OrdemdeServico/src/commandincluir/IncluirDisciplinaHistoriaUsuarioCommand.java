/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandincluir;

import command.ICommandManterOS;
import javax.swing.JOptionPane;
import model.DisciplinaHistoriaUsuario;
import model.HistoriaUsuario;
import model.OrdemServico;
import presenter.ManterOrdemServicoPresenter;
import stateincluir.IncluirDisciplinaHistoriaUsuarioState;
import stateincluir.IncluirHistoriaUsuarioState;
import stateincluir.IncluirRegistroNMSCriteriosGeraisState;

/**
 *
 * @author Josep
 */
public class IncluirDisciplinaHistoriaUsuarioCommand implements ICommandManterOS {

    private static IncluirDisciplinaHistoriaUsuarioCommand instance;

    public static IncluirDisciplinaHistoriaUsuarioCommand getInstance() {
        if (instance == null) {
            instance = new IncluirDisciplinaHistoriaUsuarioCommand();
        }
        return instance;
    }

    @Override
    public void executar(ManterOrdemServicoPresenter presenter, OrdemServico os, Object ob1, Object ob2) {

        presenter.getView().getjButtonCancelar().addActionListener((e1) -> {
            if (presenter.setJanelaConfirmacao("Deseja realmente cancelar o processo? \n A janela será fechada e a inclusão da ordem de serviço cancelada.") == 0) {
                presenter.fecharView();
            }
        });

        presenter.getView().getjButtonAvancar().addActionListener((e1) -> {
            this.salvarOS(presenter, os, ob1);
        });

    }

    @Override
    public void desfazer() {
    }

    private void salvarOS(ManterOrdemServicoPresenter presenter, OrdemServico os, Object ob1) {
        try {
            HistoriaUsuario historia = (HistoriaUsuario) ob1;

            DisciplinaHistoriaUsuario disciplina = new DisciplinaHistoriaUsuario(presenter.getView().getJTextField1().getText(),
                    presenter.getView().getJTextField2().getText(),
                    Double.parseDouble(presenter.getView().getJTextField3().getText()));

            historia.addDisciplina(disciplina);

            if (presenter.setJanelaConfirmacao("Deseja inserir mais disciplinas nessa mesma história?") == 0) {
                presenter.setState(new IncluirDisciplinaHistoriaUsuarioState(presenter));
                presenter.incluir(os, historia);
            } else {
                if (presenter.setJanelaConfirmacao("Deseja inserir mais Histórias de Usuário nesta Ordem de serviço?") == 0) {
                    presenter.setState(new IncluirHistoriaUsuarioState(presenter));
                    presenter.incluir(os, null);
                } else {
                    presenter.setState(new IncluirRegistroNMSCriteriosGeraisState(presenter));
                    presenter.incluir(os, null);
                }
            }
        } catch (NumberFormatException ex1) {
            JOptionPane.showMessageDialog(null, "Favor informar um valor válido de UST!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

}
