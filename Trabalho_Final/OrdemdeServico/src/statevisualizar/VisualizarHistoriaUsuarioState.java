/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statevisualizar;

import command.ICommandTabela;
import commandvisualizar.VisualizarHistoriaUsuarioCommand;
import state.ManterOrdemServicoTabelaState;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DisciplinaHistoriaUsuario;
import model.HistoriaUsuario;
import model.OrdemServico;
import presenter.TabelaManterOSPresenter;

/**
 *
 * @author Josep
 */
public class VisualizarHistoriaUsuarioState extends ManterOrdemServicoTabelaState {
    
    private ICommandTabela command;

    public VisualizarHistoriaUsuarioState(TabelaManterOSPresenter presenter) {
        super(presenter);
        this.configurarView();
        this.command = VisualizarHistoriaUsuarioCommand.getInstance();
    }

    @Override
    public void visualizar(Object ob1, OrdemServico os) {
        
        HistoriaUsuario historia = (HistoriaUsuario) ob1;
        this.presenter.getView().getjLabelSubTitulo().setText(historia.getNome());
        
        this.presenter.preencherCampos("Nome da História de Usuário:", historia.getNome(), "Situação da História de Usuário:", historia.getSituacao());
        try {
            this.preencherTabela(this.presenter, historia.getDisciplinas());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        this.command.executar(this.presenter, historia, os);

    }

    private DefaultTableModel montarTabela(TabelaManterOSPresenter presenter) {
        presenter.setTablemodel(new DefaultTableModel(new Object[][]{}, new String[]{"Disciplina", "Tarefa", "UST"}) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        });
        return presenter.getTablemodel();
    }

    private void preencherTabela(TabelaManterOSPresenter presenter, ArrayList<DisciplinaHistoriaUsuario> disciplinas) throws Exception {
        presenter.setTablemodel(this.montarTabela(presenter));
        for (DisciplinaHistoriaUsuario disciplinasHistoriaUsuario : disciplinas) {
            try {
                presenter.getTablemodel().addRow(new Object[]{
                    disciplinasHistoriaUsuario.getDescricao(),
                    disciplinasHistoriaUsuario.getTarefa(),
                    disciplinasHistoriaUsuario.getUST()
                });
            } catch (Exception ex) {
                throw new Exception(ex.getMessage());
            }
        }
        presenter.getView().getjTable().setModel(presenter.getTablemodel());
    }
    
    private void configurarView(){
        this.presenter.resetarConfiguracoes();
        this.presenter.getView().setTitle("Disciplinas Historia de Usuario (Visualização / Edição)");
        this.presenter.getView().getjLabelTitulo().setText("Disciplina História de Usuário");
        this.presenter.visibilidadeCampos(true, true, true, true);
        this.presenter.bloquearTextFields(false, false);
        this.presenter.getView().setVisible(true);
        this.presenter.getView().getjButtonAvancar().setText("Excluir");
        this.presenter.getView().getjButtonCancelar().setText("Sair");
    }

}
