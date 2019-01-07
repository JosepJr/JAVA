/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandvisualizar;

import command.ICommandManterOS;
import model.CriterioGeralNMS;
import model.OrdemServico;
import presenter.ManterOrdemServicoPresenter;
import stateeditar.EditarCriterioGeralNMSState;

/**
 *
 * @author Josep
 */
public class VisualizarCriterioGeralNMSCommand implements ICommandManterOS{

    private static VisualizarCriterioGeralNMSCommand instance;
    
    public static VisualizarCriterioGeralNMSCommand getInstance(){
        if(instance == null){
            instance = new VisualizarCriterioGeralNMSCommand();
        }
        return instance;
    }
    
    @Override
    public void executar(ManterOrdemServicoPresenter presenter, OrdemServico os, Object ob1, Object ob2) {
        
        CriterioGeralNMS criterio = (CriterioGeralNMS) ob1;
        
        presenter.preencherTextField(criterio.getCriterio(), 
                Double.toString(criterio.getRedutor()), 
                criterio.getAplicacao(), 
                Integer.toString(criterio.getQuantidade()), 
                criterio.getObservacao(), 
                Double.toString(criterio.getValorReducao()), 
                "", 
                "");
        
        presenter.getView().getjButtonAvancar().addActionListener((e) -> {
            presenter.setState(new EditarCriterioGeralNMSState(presenter));
            presenter.editar(os, criterio, ob2);
        });
        
        presenter.getView().getjButtonCancelar().addActionListener((e) -> {
            presenter.fecharView();
        });
    }

    @Override
    public void desfazer() {
    }
    
}
