/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statevisualizar;

import command.ICommandTabela;
import commandvisualizar.VisualizarHistoriasUsuarioCommand;
import state.ManterOrdemServicoTabelaState;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.HistoriaUsuario;
import model.OrdemServico;
import presenter.TabelaManterOSPresenter;

/**
 *
 * @author Josep
 */
public class VisualizarHistoriasUsuarioState extends ManterOrdemServicoTabelaState {

    private ICommandTabela command;

    public VisualizarHistoriasUsuarioState(TabelaManterOSPresenter presenter) {
        super(presenter);
        this.configurarView();
        this.command = VisualizarHistoriasUsuarioCommand.getInstance();
    }

    @Override
    public void visualizar(Object ob1, OrdemServico os) {
        try {
            this.preencherTabela(os);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        this.command.executar(this.presenter, ob1, os);

    }

    private void configurarView() {

        this.presenter.resetarConfiguracoes();
        this.presenter.getView().setTitle("Histórias de Usuário (Visualização / Edição)");
        this.presenter.getView().getjLabelTitulo().setText("Histórias de Usuário");
        this.presenter.getView().getjButtonEditar().setText("Excluir");
        this.presenter.getView().getjButtonCancelar().setText("Sair");
        this.presenter.getView().setVisible(true);

    }

    private DefaultTableModel montarTabela() {
        this.presenter.setTablemodel(new DefaultTableModel(new Object[][]{}, new String[]{"Nome da História de Usuário", "Situacao da História de Usuário"}) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        });
        return this.presenter.getTablemodel();
    }

    private void preencherTabela(OrdemServico os) throws Exception {
        this.presenter.setTablemodel(this.montarTabela());
        for (HistoriaUsuario historias : os.getHistoriasUsuarios()) {
            try {
                this.presenter.getTablemodel().addRow(new Object[]{
                    historias.getNome(),
                    historias.getSituacao()
                });
            } catch (Exception ex) {
                throw new Exception(ex.getMessage());
            }
        }
        this.presenter.getView().getjTable().setModel(this.presenter.getTablemodel());
    }
}
