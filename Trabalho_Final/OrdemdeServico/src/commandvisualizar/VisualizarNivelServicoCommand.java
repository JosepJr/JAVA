/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandvisualizar;

import command.ICommandManterOS;
import model.NivelServico;
import model.OrdemServico;
import presenter.ManterOrdemServicoPresenter;
import stateeditar.EditarNivelServicoState;

/**
 *
 * @author Josep
 */
public class VisualizarNivelServicoCommand implements ICommandManterOS {

    private static VisualizarNivelServicoCommand instance;

    public static VisualizarNivelServicoCommand getInstance() {
        if (instance == null) {
            instance = new VisualizarNivelServicoCommand();
        }
        return instance;
    }

    @Override
    public void executar(ManterOrdemServicoPresenter presenter, OrdemServico os, Object ob1, Object ob2) {

        NivelServico nivelServico = (NivelServico) ob1;
        
        System.out.println(nivelServico.toString());

        presenter.preencherTextField(nivelServico.getIndicador(),
                Integer.toString(nivelServico.getResultado()),
                Double.toString(nivelServico.getRedutor()),
                Double.toString(nivelServico.getValorReducao()),
                "",
                "",
                "",
                "");

        presenter.getView().getjButtonAvancar().addActionListener((e) -> {
            presenter.setState(new EditarNivelServicoState(presenter));
            presenter.editar(os, nivelServico, ob2);
        });

        presenter.getView().getjButtonCancelar().addActionListener((e) -> {
            presenter.fecharView();
        });

    }

    @Override
    public void desfazer() {
    }

}
