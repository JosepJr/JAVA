/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statevisualizar;

import command.ICommandManterOS;
import commandvisualizar.VisualizarSituacaoOrdemServicoCommand;
import model.OrdemServico;
import presenter.ManterOrdemServicoPresenter;
import state.ManterOrdemServicoState;

/**
 *
 * @author Josep
 */
public class VisualizarSituacaoOrdemServicoState extends ManterOrdemServicoState {

    private ICommandManterOS command;
    
    public VisualizarSituacaoOrdemServicoState(ManterOrdemServicoPresenter presenter) {
        super(presenter);
        this.configurarStateView();
        this.command = VisualizarSituacaoOrdemServicoCommand.getInstance();
    }

    @Override
    public void visualizar(OrdemServico os, Object ob1, Object ob2) {

        this.command.executar(this.presenter, os, null, null);

    }

    private void configurarStateView() {
        this.presenter.resetarTudo();
        this.presenter.setLabelTitulo("Situação (Status) da Ordem de Serviço", true);
        this.presenter.getView().setTitle("Manter Situação da Ordem de Serviço (Inclusão / Edição)");
        this.presenter.setTextLabels("Data:", "Nome do Profissional Responsável:", "Função na Equipe:", "", "", "", "", "");
        this.presenter.setVisibleLabels(true, true, true, false, false, false, false, false);
        this.presenter.setVisibileTextFields(true, true, true, false, false, false, false, false);
        this.presenter.getView().getjButtonEditar().setVisible(true);
        this.presenter.getView().getjComboBoxSituacao().setEnabled(false);
        this.presenter.habilitarTextField(false, false, false, true, true, true, true, true);
        this.presenter.getView().getjButtonCancelar().setText("Sair");
        this.presenter.getView().moveToFront();
        this.presenter.getView().setVisible(true);
    }

}
