/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateincluir;

import command.ICommandManterOS;
import commandincluir.IncluirDisciplinaHistoriaUsuarioCommand;
import state.ManterOrdemServicoState;

import model.OrdemServico;
import presenter.ManterOrdemServicoPresenter;


/**
 *
 * @author Josep
 */
public class IncluirDisciplinaHistoriaUsuarioState extends ManterOrdemServicoState {

    private ICommandManterOS command;
    
    public IncluirDisciplinaHistoriaUsuarioState(ManterOrdemServicoPresenter presenter) {
        super(presenter);       
        this.configurarViewState();
        this.command = IncluirDisciplinaHistoriaUsuarioCommand.getInstance();
    }

    @Override
    public void incluir(OrdemServico os, Object ob1) {
        
        this.command.executar(this.presenter, os, ob1, null);
    
    }

    private void configurarViewState() {
        this.presenter.resetarTudo();
        this.presenter.setTextLabels("Disciplina:", "Tarefa:", "UST:", "", "", "","","");
        this.presenter.setVisibleLabels(true, true, true, false, false, false, false, false);
        this.presenter.setVisibileTextFields(true, true, true, false, false, false, false, false);
        this.presenter.getView().setTitle("Disciplina História de Usuário (Inclusão / Edição)");
        this.presenter.setLabelTitulo("História de Usuário", true);
        this.presenter.getView().setVisible(true);
        this.presenter.getView().moveToFront();
    }

}
