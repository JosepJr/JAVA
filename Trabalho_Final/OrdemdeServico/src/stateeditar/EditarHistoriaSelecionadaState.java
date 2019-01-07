/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateeditar;

import state.ManterOrdemServicoTabelaState;
import command.ICommandTabela;
import commandeditar.EditarHistoriaUsuarioCommand;
import model.OrdemServico;
import presenter.TabelaManterOSPresenter;

/**
 *
 * @author Josep
 */
public class EditarHistoriaSelecionadaState extends ManterOrdemServicoTabelaState {

    private ICommandTabela command;

    public EditarHistoriaSelecionadaState(TabelaManterOSPresenter presenter) {
        super(presenter);
        this.presenter.resetActionListeners();
        this.presenter.bloquearTextFields(true, true);

        this.presenter.getView().getjButtonEditar().setText("Salvar");
        this.presenter.getView().getjButtonCancelar().setText("Cancelar");
        this.presenter.getView().getjButtonVisualizar().setEnabled(false);
        this.presenter.getView().getjButtonAvancar().setEnabled(false);
        this.command = EditarHistoriaUsuarioCommand.getInstance();
    }

    @Override
    public void editar(Object ob1, OrdemServico os) {
        
        this.command.executar(this.presenter, ob1, os);

    }

}
