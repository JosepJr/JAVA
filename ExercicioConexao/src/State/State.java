/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import Control.Conexao;
import Control.Requisicao;
import Control.Resposta;
import Model.Usuario;

/**
 *
 * @author Josep
 */
public abstract class State {
    
    protected  Conexao conexao;
    
    public State(Conexao conexao){
        this.conexao = conexao;
    }
    
    public void conectar(Usuario usuario, Requisicao requisicao){
    
    }
    
    public void desconectar(Usuario usuario){
    
    }
    
    public void resposta(Usuario usuario, Resposta resposta){
    
    }
    
    public void requisicao(Usuario usuario, Requisicao requisicao){
    
    }
    
}
