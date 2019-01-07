/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateincluir;

import state.ManterOrdemServicoState;
import model.OrdemServico;
import presenter.ManterOrdemServicoPresenter;
import command.ICommandManterOS;
import commandincluir.IncluirRegistroNMSCriteriosGeraisCommand;

/**
 *
 * @author Josep
 */
public class IncluirRegistroNMSCriteriosGeraisState extends ManterOrdemServicoState {

    private final ICommandManterOS command;

    public IncluirRegistroNMSCriteriosGeraisState(ManterOrdemServicoPresenter presenter) {
        super(presenter);
        this.configurarViewState();
        this.command = IncluirRegistroNMSCriteriosGeraisCommand.getInstance();
    }

    @Override
    public void incluir(OrdemServico os, Object ob1) {

        this.command.executar(this.presenter, os, ob1, null); 
        
    }

    private void configurarViewState() {
        this.presenter.resetarTudo();
        this.presenter.setLabelTitulo("Critérios Gerais de NMS", true);
        this.presenter.getView().setTitle("Manter Registro Nível Mínimo Serviço (Inclusão / Edição)");
        this.presenter.setTextLabels("Critério:", "Redutor (%):", "Aplicação:", "Quantidade:", "Observações (explicações, motivos):", "Valor da Redução (R$):", "", "");
        this.presenter.setVisibleLabels(true, true, true, true, true, true, false, false);
        this.presenter.configurarLabelValores(false, false, false, false, false, false, false, false, false, false);
        this.presenter.setVisibileTextFields(true, true, true, true, true, true, false, false);
        this.presenter.getView().moveToFront();
        this.presenter.getView().setVisible(true);
    }

}
