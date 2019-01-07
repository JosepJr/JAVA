/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateeditar;

import command.ICommandManterOS;
import commandeditar.EditarNivelServicoCommand;
import model.NivelServico;
import model.OrdemServico;
import presenter.ManterOrdemServicoPresenter;
import state.ManterOrdemServicoState;

/**
 *
 * @author Josep
 */
public class EditarNivelServicoState extends ManterOrdemServicoState {

    private ICommandManterOS command;

    public EditarNivelServicoState(ManterOrdemServicoPresenter presenter) {
        super(presenter);
        this.presenter.resetActionListeners();
        this.presenter.getView().getjButtonCancelar().setText("Cancelar");
        this.presenter.getView().getjButtonAvancar().setText("Salvar");
        this.presenter.habilitarTextField(true, true, true, true, false, false, false, false);
        this.command = EditarNivelServicoCommand.getInstance();
    }

    @Override
    public void editar(OrdemServico os, Object ob1, Object ob2) {

        this.command.executar(presenter, os, ob1, ob2);

    }

}
