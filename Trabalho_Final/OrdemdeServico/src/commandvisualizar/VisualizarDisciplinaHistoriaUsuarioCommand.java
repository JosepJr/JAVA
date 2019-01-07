/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandvisualizar;

import command.ICommandManterOS;
import model.DisciplinaHistoriaUsuario;
import model.HistoriaUsuario;
import model.OrdemServico;
import presenter.ManterOrdemServicoPresenter;
import stateeditar.EditarDisciplinaHistoriaUsuarioState;

/**
 *
 * @author Josep
 */
public class VisualizarDisciplinaHistoriaUsuarioCommand implements ICommandManterOS {

    private static VisualizarDisciplinaHistoriaUsuarioCommand instance;

    public static VisualizarDisciplinaHistoriaUsuarioCommand getInstance() {
        if (instance == null) {
            instance = new VisualizarDisciplinaHistoriaUsuarioCommand();
        }
        return instance;
    }

    @Override
    public void executar(ManterOrdemServicoPresenter presenter, OrdemServico os, Object ob1, Object ob2) {
        DisciplinaHistoriaUsuario disciplina = (DisciplinaHistoriaUsuario) ob1;
        HistoriaUsuario historia = (HistoriaUsuario) ob2;
        
        presenter.preencherTextField(disciplina.getDescricao(), disciplina.getTarefa(), Double.toString(disciplina.getUST()), "", "", "", "", "");

        presenter.getView().getjButtonCancelar().addActionListener((e1) -> {
            presenter.fecharView();            
        });

        presenter.getView().getjButtonAvancar().addActionListener((e) -> {
            presenter.setState(new EditarDisciplinaHistoriaUsuarioState(presenter));
            presenter.editar(os, disciplina, historia);
        });

    }

    @Override
    public void desfazer() {
    }
   

}
