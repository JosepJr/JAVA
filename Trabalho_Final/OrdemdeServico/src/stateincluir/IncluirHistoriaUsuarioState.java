/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateincluir;

import command.ICommandManterOS;
import commandincluir.IncluirHistoriaUsuarioCommand;
import state.ManterOrdemServicoState;
import model.OrdemServico;
import presenter.ManterOrdemServicoPresenter;

/**
 *
 * @author Josep
 */
public class IncluirHistoriaUsuarioState extends ManterOrdemServicoState {

    private ICommandManterOS command;
    
    
    public IncluirHistoriaUsuarioState(ManterOrdemServicoPresenter presenter) {
        super(presenter);
        this.configurarViewState();
        this.command = IncluirHistoriaUsuarioCommand.getInstance();
    }

    @Override
    public void incluir(OrdemServico os, Object ob1) {
        
        this.command.executar(this.presenter, os, null, null);   

    }

    private void configurarViewState() {
        this.presenter.resetarTudo();
        this.presenter.setLabelTitulo("História de Usuário", true);
        this.presenter.setTextLabels("Nome da história do Usuário:", "Disciplina:", "Tarefa:", "UST:", "Situação da História de Usuário:", "", "", "");
        this.presenter.setVisibleLabels(true, true, true, true, true, false, false, false);
        this.presenter.setVisibileTextFields(true, true, true, true, true, false, false, false);
        this.presenter.getView().setTitle("Histórias de Usuários (Inclusão / Edição)");
        this.presenter.getView().setVisible(true);
        this.presenter.getView().moveToFront();
    }

}
