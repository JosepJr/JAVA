/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statevisualizar;

import commandvisualizar.VisualizarNivelServicoCommand;
import model.OrdemServico;
import presenter.ManterOrdemServicoPresenter;
import state.ManterOrdemServicoState;

/**
 *
 * @author Josep
 */
public class VisualizarNivelServicoState extends ManterOrdemServicoState {

    private VisualizarNivelServicoCommand command;
    
    public VisualizarNivelServicoState(ManterOrdemServicoPresenter presenter) {
        super(presenter);
        this.configurarViewState();
        this.command = VisualizarNivelServicoCommand.getInstance();
    }

    @Override
    public void visualizar(OrdemServico os, Object ob1, Object ob2) {
        
        this.command.executar(this.presenter, os, ob1, null);

    }

    private void configurarViewState() {
        this.presenter.resetarTudo();
        this.presenter.setLabelTitulo("Nivel de Serviço", true);
        this.presenter.getView().setTitle("Manter Mínimo de Serviço (Inclusão / Edição)");
        this.presenter.setTextLabels("Indicador:", "Resultado:", "Redutor:", "Valor da Redução (R$):", "", "", "", "");
        this.presenter.setVisibleLabels(true, true, true, true, false, false, false, false);
        this.presenter.configurarLabelValores(false, false, false, false, false, false, false, false, false, false);
        this.presenter.habilitarTextField(false, false, false, false, false, false, false, false);
        this.presenter.setVisibileTextFields(true, true, true, true, false, false, false, false);
        this.presenter.getView().getjButtonAvancar().setText("Editar");
        this.presenter.getView().getjButtonCancelar().setText("Sair");
        this.presenter.getView().moveToFront();
        this.presenter.getView().setVisible(true);
    }
}
