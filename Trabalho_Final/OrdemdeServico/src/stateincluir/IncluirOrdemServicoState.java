/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateincluir;

import command.ICommandManterOS;
import commandincluir.IncluirOrdemServicoCommand;
import state.ManterOrdemServicoState;
import model.OrdemServico;
import presenter.ManterOrdemServicoPresenter;

/**
 *
 * @author Josep
 */
public class IncluirOrdemServicoState extends ManterOrdemServicoState {

    private ICommandManterOS command;

    public IncluirOrdemServicoState(ManterOrdemServicoPresenter presenter) {
        super(presenter);
        this.configurarViewState();
        this.command = IncluirOrdemServicoCommand.getInstance();
    }

    @Override
    public void incluir(OrdemServico os, Object ob1) {
        this.command.executar(this.presenter, os, null, null);  
    }

    private void configurarViewState() {
        this.presenter.resetarTudo();
        this.presenter.setLabelTitulo("Ordem de Serviço", true);
        this.presenter.getView().setTitle("Manter Ordem de Serviço (Inclusão / Edição)");
        this.presenter.setTextLabels("Número da Ordem de Serviço (OS):", "Data da Emissão:", "Nome do Fiscal Técnico Emissor:", "", "", "", "", "");
        this.presenter.setVisibleLabels(true, true, true, false, false, false, false, false);
        this.presenter.setVisibileTextFields(true, true, true, false, false, false, false, false);
        this.presenter.getView().setVisible(true);
        this.presenter.getView().moveToFront();
    }

}
