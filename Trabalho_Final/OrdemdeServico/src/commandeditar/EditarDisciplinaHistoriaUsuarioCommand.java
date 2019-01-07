/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandeditar;

import command.ICommandManterOS;
import javax.swing.JOptionPane;
import model.DisciplinaHistoriaUsuario;
import model.HistoriaUsuario;
import model.OrdemServico;
import presenter.BuscarOrdemServicoPresenter;
import presenter.ManterOrdemServicoPresenter;
import presenter.TabelaManterOSPresenter;
import statevisualizar.VisualizarDisciplinaHistoriaUsuarioState;
import statevisualizar.VisualizarHistoriaUsuarioState;
import statevisualizar.VisualizarHistoriasUsuarioState;
import test.DadosTeste;

/**
 *
 * @author Josep
 */
public class EditarDisciplinaHistoriaUsuarioCommand implements ICommandManterOS {

    private static EditarDisciplinaHistoriaUsuarioCommand instance;

    private EditarDisciplinaHistoriaUsuarioCommand() {
    }

    public static EditarDisciplinaHistoriaUsuarioCommand getinstance() {
        if (instance == null) {
            instance = new EditarDisciplinaHistoriaUsuarioCommand();
        }
        return instance;
    }

    @Override
    public void executar(ManterOrdemServicoPresenter presenter, OrdemServico os, Object ob1, Object ob2) {

        DisciplinaHistoriaUsuario disciplina = (DisciplinaHistoriaUsuario) ob1;
        HistoriaUsuario historia = (HistoriaUsuario) ob2;

        presenter.getView().getjButtonAvancar().addActionListener((e) -> {
            this.atualizarInformacoesOS(presenter, os, disciplina, historia);
        });

        presenter.getView().getjButtonCancelar().addActionListener((e) -> {
            if (presenter.setJanelaConfirmacao("Deseja realmente cancelar a edição desta disciplina história de usuário?") == 0) {
                presenter.setState(new VisualizarDisciplinaHistoriaUsuarioState(presenter));
                presenter.visualizar(os, disciplina, historia);
            }
        });

    }

    @Override
    public void desfazer() {

    }

    private void atualizarInformacoesOS(ManterOrdemServicoPresenter presenter, OrdemServico os, DisciplinaHistoriaUsuario disciplina, HistoriaUsuario historia) {
        try {

            DadosTeste.getInstance().getOrdensServico().remove(os);
            historia.getDisciplinas().remove(disciplina);
            os.getHistoriasUsuarios().remove(historia);
            disciplina.setDescricao(presenter.getView().getJTextField1().getText());
            disciplina.setTarefa(presenter.getView().getJTextField2().getText());
            disciplina.setUST(Double.parseDouble(presenter.getView().getJTextField3().getText()));
            historia.addDisciplina(disciplina);
            os.addHistoriaUsuario(historia);

            this.realizarUpdate(presenter, os, historia, disciplina);

        } catch (NumberFormatException ex1) {
            JOptionPane.showMessageDialog(null, "Favor informar um valor valido para o UST");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    private void realizarUpdate(ManterOrdemServicoPresenter presenter, OrdemServico os, HistoriaUsuario historia, DisciplinaHistoriaUsuario disciplina) {
        try {

            DadosTeste.getInstance().addOrdemServico(os);
            BuscarOrdemServicoPresenter.getInstance().preencherTabela();

            TabelaManterOSPresenter presenter2 = TabelaManterOSPresenter.getInstance();

            presenter2.setState(new VisualizarHistoriasUsuarioState(presenter2));
            presenter2.visualizar(null, os);

            presenter2.setState(new VisualizarHistoriaUsuarioState(presenter2));
            presenter2.visualizar(historia, os);

            presenter.setState(new VisualizarDisciplinaHistoriaUsuarioState(presenter));
            presenter.visualizar(os, disciplina, historia);

            JOptionPane.showMessageDialog(null, "Disciplina de historia de usuário atualizada com sucesso!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

}
