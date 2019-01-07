/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateeditar;

import command.ICommandManterOS;
import commandeditar.EditarCriterioGeralNMSCommand;
import model.OrdemServico;
import presenter.ManterOrdemServicoPresenter;
import state.ManterOrdemServicoState;

/**
 *
 * @author Josep
 */
public class EditarCriterioGeralNMSState extends ManterOrdemServicoState {

    private ICommandManterOS command;

    public EditarCriterioGeralNMSState(ManterOrdemServicoPresenter presenter) {
        super(presenter);
        this.presenter.resetActionListeners();
        this.presenter.getView().getjButtonCancelar().setText("Cancelar");
        this.presenter.getView().getjButtonAvancar().setText("Salvar");
        this.presenter.habilitarTextField(true, true, true, true, true, true, false, false);
        this.command = EditarCriterioGeralNMSCommand.getInstance();
    }

    @Override
    public void editar(OrdemServico os, Object ob1, Object ob2) {      
        this.command.executar(presenter, os, ob1, ob2);
    }
}
