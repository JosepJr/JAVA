/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statevisualizar;

import command.ICommandManterOS;
import commandvisualizar.VisualizarDisciplinaHistoriaUsuarioCommand;
import model.OrdemServico;
import presenter.ManterOrdemServicoPresenter;
import state.ManterOrdemServicoState;

/**
 *
 * @author Josep
 */
public class VisualizarDisciplinaHistoriaUsuarioState extends ManterOrdemServicoState {

    private ICommandManterOS command;
    
    public VisualizarDisciplinaHistoriaUsuarioState(ManterOrdemServicoPresenter presenter) {     
        super(presenter);
        this.configurarViewState();
        
        this.command = VisualizarDisciplinaHistoriaUsuarioCommand.getInstance();
        
    }

    @Override
    public void visualizar(OrdemServico os, Object ob1, Object ob2) {
            
        this.command.executar(presenter, os, ob1, ob2);
        
        
    }

    private void configurarViewState() {
        this.presenter.resetarTudo();
        this.presenter.getView().setTitle("Histórias de Usuários (Inclusão / Edição)");
        this.presenter.setTextLabels("Disciplina:", "Tarefa:", "UST:", "", "", "", "", "");
        this.presenter.setVisibleLabels(true, true, true, false, false, false, false, false);
        this.presenter.setVisibileTextFields(true, true, true, false, false, false, false, false);
        this.presenter.setLabelTitulo("Disciplina História de Usuário", true);
        this.presenter.habilitarTextField(false, false, false, false, false, false, false, false);
        this.presenter.getView().getjButtonAvancar().setText("Editar");
        this.presenter.getView().getjButtonCancelar().setText("Sair");
        this.presenter.getView().setVisible(true);
        this.presenter.getView().moveToFront();
        
    }

}
