/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import model.OrdemServico;
import presenter.TabelaManterOSPresenter;

/**
 *
 * @author Josep
 */
public abstract class ManterOrdemServicoTabelaState {
    
     protected TabelaManterOSPresenter presenter;  
    
    public ManterOrdemServicoTabelaState(TabelaManterOSPresenter presenter) {
        this.presenter = presenter;
    }

    public void visualizar(Object ob1, OrdemServico os) {
        throw new IllegalStateException();
    }
    
    public void editar(Object ob1, OrdemServico os){
        throw new IllegalStateException();
    }

}
