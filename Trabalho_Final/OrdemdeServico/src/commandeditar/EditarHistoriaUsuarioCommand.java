/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandeditar;

import command.ICommandTabela;
import javax.swing.JOptionPane;
import model.HistoriaUsuario;
import model.OrdemServico;
import presenter.BuscarOrdemServicoPresenter;
import presenter.TabelaManterOSPresenter;
import statevisualizar.VisualizarHistoriaUsuarioState;
import test.DadosTeste;

/**
 *
 * @author Josep
 */
public class EditarHistoriaUsuarioCommand implements ICommandTabela {

    private static EditarHistoriaUsuarioCommand instance;

    public static EditarHistoriaUsuarioCommand getInstance() {
        if (instance == null) {
            instance = new EditarHistoriaUsuarioCommand();
        }
        return instance;
    }

    @Override
    public void executar(TabelaManterOSPresenter presenter, Object ob1, OrdemServico os) {

        HistoriaUsuario historia = (HistoriaUsuario) ob1;

        presenter.getView().getjButtonCancelar().addActionListener((e1) -> {
            if (presenter.setJanelaConfirmacao("Deseja realmente cancelar a edição desta História de Usuário?\n Atualizações já feitas serão mantidas.") == 0) {
                presenter.setState(new VisualizarHistoriaUsuarioState(presenter));
                presenter.visualizar(historia, os);
            }
        });

        presenter.getView().getjButtonEditar().addActionListener((e) -> {
            this.atualizarInformacoesOS(presenter, historia, os);
        });
    }

    @Override
    public void desfazer() {
    }

    private void atualizarInformacoesOS(TabelaManterOSPresenter presenter, HistoriaUsuario historia, OrdemServico os) {
        try {
            os.getHistoriasUsuarios().remove(historia);
            historia.setNome(presenter.getView().getjTextField1().getText());
            historia.setSituacao(presenter.getView().getjTextField2().getText());
            this.realizarUpdate(presenter, os, historia);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }

    private void realizarUpdate(TabelaManterOSPresenter presenter, OrdemServico os, HistoriaUsuario historia) {
        try {
            DadosTeste.getInstance().getOrdensServico().remove(os);

            os.getHistoriasUsuarios().add(historia);
            DadosTeste.getInstance().addOrdemServico(os);

            BuscarOrdemServicoPresenter.getInstance().preencherTabela();

            presenter.setState(new VisualizarHistoriaUsuarioState(presenter));
            presenter.visualizar(historia, os);

            JOptionPane.showMessageDialog(null, "Historia de Servico selecionada atualizada com sucesso!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

}
