/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateincluir;

import command.ICommandManterOS;
import commandincluir.IncluirSituacaoOrdemServicoCommand;
import state.ManterOrdemServicoState;
import model.OrdemServico;
import presenter.ManterOrdemServicoPresenter;

/**
 *
 * @author Josep
 */
public class IncluirSituacaoOrdemServicoState extends ManterOrdemServicoState {

    private ICommandManterOS command;
    
    public IncluirSituacaoOrdemServicoState(ManterOrdemServicoPresenter presenter) {
        super(presenter);
        this.configurarStateView();
        this.command = IncluirSituacaoOrdemServicoCommand.getInstance();
    }

    @Override
    public void incluir(OrdemServico os, Object ob1) {
        
        this.command.executar(this.presenter, os, null, null);   

    }

    private void configurarStateView() {
        this.presenter.resetarTudo();
        this.presenter.setLabelTitulo("Situação (Status) da Ordem de Serviço", true);
        this.presenter.getView().setTitle("Manter Situação da Ordem de Serviço (Inclusão / Edição)");
        this.presenter.setTextLabels("Data:", "Nome do Profissional Responsável:", "Função na Equipe:", "", "", "", "", "");
        this.presenter.setVisibleLabels(true, true, true, false, false, false, false, false);
        this.presenter.setVisibileTextFields(true, true, true, false, false, false, false, false);
        this.presenter.configurarVisibleSituacao(true, true, false);
        this.presenter.getView().getjComboBoxSituacao().setEnabled(false);
        this.presenter.getView().moveToFront();
        this.presenter.getView().setVisible(true);
    }
}
