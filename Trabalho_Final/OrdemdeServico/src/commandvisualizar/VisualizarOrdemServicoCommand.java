/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandvisualizar;

import command.ICommandManterOS;
import model.OrdemServico;
import presenter.ManterOrdemServicoPresenter;
import stateeditar.EditarOrdemServicoState;
import statevisualizar.VisualizarSituacaoOrdemServicoState;

/**
 *
 * @author Josep
 */
public class VisualizarOrdemServicoCommand implements ICommandManterOS {

    private static VisualizarOrdemServicoCommand instance;

    public static VisualizarOrdemServicoCommand getInstance() {
        if (instance == null) {
            instance = new VisualizarOrdemServicoCommand();
        }
        return instance;
    }

    @Override
    public void executar(ManterOrdemServicoPresenter presenter, OrdemServico os, Object ob1 , Object ob2) {
        presenter.preencherTextField(Integer.toString(os.getNumero()), os.getDataEmissao(), os.getNomeFiscalEmissor(), "", "", "", "", "");

        presenter.getView().getjButtonCancelar().addActionListener((e1) -> {
            if (presenter.setJanelaConfirmacao("Deseja realmente sair? \n A janela será fechada e o restante da edição da Ordem de Serviço(OS) não será realizada.\n Atualizações já feitas serão mantidas.") == 0) {
                presenter.fecharView();
            }
        });

        presenter.getView().getjButtonAvancar().addActionListener((e1) -> {
            presenter.setState(new VisualizarSituacaoOrdemServicoState(presenter));
            presenter.visualizar(os, null, null);
        });

        presenter.getView().getjButtonEditar().addActionListener((e1) -> {
            presenter.setState(new EditarOrdemServicoState(presenter));
            presenter.editar(os, null, null);
        });
    }

    @Override
    public void desfazer() {
    }

}
