/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statevisualizar;

import command.ICommandManterOS;
import commandvisualizar.VisualizarOrdemServicoCommand;
import model.OrdemServico;
import presenter.ManterOrdemServicoPresenter;
import state.ManterOrdemServicoState;

/**
 *
 * @author Josep
 */
public class VisualizarOrdemServicoState extends ManterOrdemServicoState {

    private ICommandManterOS command;
    
    public VisualizarOrdemServicoState(ManterOrdemServicoPresenter presenter) {
        super(presenter);
        this.configurarViewState();
        this.command = VisualizarOrdemServicoCommand.getInstance();
    }

    @Override
    public void visualizar(OrdemServico os, Object ob1, Object ob2) {    
        
        this.command.executar(this.presenter, os, null, null);    
    }

    private void configurarViewState() {
        this.presenter.resetarTudo();
        this.presenter.setLabelTitulo("Ordem de Serviço", true);
        this.presenter.getView().setTitle("Manter Ordem de Serviço (Inclusão / Edição)");
        this.presenter.setTextLabels("Número da Ordem de Serviço (OS):", "Data da Emissão:", "Nome do Fiscal Técnico Emissor:", "", "", "", "", "");
        this.presenter.setVisibleLabels(true, true, true, false, false, false, false, false);
        this.presenter.setVisibileTextFields(true, true, true, false, false, false, false, false);
        this.presenter.getView().getjButtonCancelar().setText("Sair");
        this.presenter.habilitarTextField(false, false, false, true, true, true, true, true);
        this.presenter.getView().getjButtonEditar().setVisible(true);
        this.presenter.getView().setVisible(true);
        this.presenter.getView().moveToFront();
    }
}
