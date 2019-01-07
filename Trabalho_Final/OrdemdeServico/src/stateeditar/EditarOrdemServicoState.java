/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateeditar;

import command.ICommandManterOS;
import commandeditar.EditarOrdemServicoCommand;
import model.OrdemServico;
import presenter.ManterOrdemServicoPresenter;
import state.ManterOrdemServicoState;

/**
 *
 * @author Josep
 */
public class EditarOrdemServicoState extends ManterOrdemServicoState {

    private ICommandManterOS command;

    public EditarOrdemServicoState(ManterOrdemServicoPresenter presenter) {
        super(presenter);
        this.presenter.resetActionListeners();
        this.presenter.getView().getjButtonEditar().setText("Salvar");
        this.presenter.habilitarTextField(true, true, true, true, true, true, true, true);
        this.presenter.getView().getjButtonAvancar().setEnabled(false);
        this.command = EditarOrdemServicoCommand.getInstance();
    }

    @Override
    public void editar(OrdemServico os, Object ob1, Object ob2) {
        
        this.command.executar(this.presenter, os, null, null);

    }
}
