/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statevisualizar;

import command.ICommandManterOS;
import commandvisualizar.VisualizarCriterioGeralNMSCommand;
import model.OrdemServico;
import presenter.ManterOrdemServicoPresenter;
import state.ManterOrdemServicoState;

/**
 *
 * @author Josep
 */
public class VisualizarCriterioGeralNMSState extends ManterOrdemServicoState {

    private ICommandManterOS command;
    
    public VisualizarCriterioGeralNMSState(ManterOrdemServicoPresenter presenter) {
        super(presenter);
        this.configurarViewState();
        this.command = VisualizarCriterioGeralNMSCommand.getInstance();
    }

    @Override
    public void visualizar(OrdemServico os, Object ob1, Object ob2) {
        
        this.command.executar(this.presenter, os, ob1, ob2);
 
    }

    private void configurarViewState() {
        this.presenter.resetarTudo();
        this.presenter.setLabelTitulo("Critérios Gerais de NMS", true);
        this.presenter.getView().setTitle("Manter Registro Nível Mínimo Serviço (Inclusão / Edição)");
        this.presenter.setTextLabels("Critério:", "Redutor (%):", "Aplicação:", "Quantidade:", "Observações (explicações, motivos):", "Valor da Redução (R$):", "", "");
        this.presenter.setVisibleLabels(true, true, true, true, true, true, false, false);
        this.presenter.configurarLabelValores(false, false, false, false, false, false, false, false, false, false);
        this.presenter.habilitarTextField(false, false, false, false, false, false, false, false);
        this.presenter.setVisibileTextFields(true, true, true, true, true, true, false, false);
        this.presenter.getView().getjButtonAvancar().setText("Editar");
        this.presenter.getView().getjButtonCancelar().setText("Sair");
        this.presenter.getView().moveToFront();
        this.presenter.getView().setVisible(true);
    }

}
