/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import Control.Conexao;
import Model.Usuario;

/**
 *
 * @author Josep
 */
public class DesconectadaState extends State {
    
    public DesconectadaState(Conexao conexao) {
        super(conexao);
    }
    
    
    
    @Override
    public void conectar(Usuario usuario){
        
    }
    
    @Override
    public void desconectar(Usuario usuario){
    
    }
    
    
}
