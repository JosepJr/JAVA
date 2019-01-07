/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import model.OrdemServico;
import presenter.ManterOrdemServicoPresenter;

/**
 *
 * @author Josep
 */
public interface ICommandManterOS {
  
    public void executar(ManterOrdemServicoPresenter presenter, OrdemServico os, Object ob1, Object ob2);
    
    public void desfazer();
    

    
}
