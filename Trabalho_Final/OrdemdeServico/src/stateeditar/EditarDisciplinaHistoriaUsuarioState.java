/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateeditar;

import command.ICommandManterOS;
import commandeditar.EditarDisciplinaHistoriaUsuarioCommand;
import model.OrdemServico;
import presenter.ManterOrdemServicoPresenter;
import state.ManterOrdemServicoState;

/**
 *
 * @author Josep
 */
public class EditarDisciplinaHistoriaUsuarioState extends ManterOrdemServicoState {

    private final ICommandManterOS command;

    public EditarDisciplinaHistoriaUsuarioState(ManterOrdemServicoPresenter presenter) {
        super(presenter);
        this.presenter.resetActionListeners();
        this.presenter.getView().getjButtonAvancar().setText("Salvar");
        this.presenter.getView().getjButtonCancelar().setText("Cancelar");
        this.presenter.habilitarTextField(true, true, true, false, false, false, false, false);
        this.command = EditarDisciplinaHistoriaUsuarioCommand.getinstance();
    }

    @Override
    public void editar(OrdemServico os, Object ob1, Object ob2) {
        this.command.executar(this.presenter, os, ob1, ob2);
    }

}
