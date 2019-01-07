/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questaoconexaomensagemrequisicao;

import state.ConexaoState;
import state.Desconectado;

/**
 *
 * @author Josep
 */
public class Conexao {
    private ConexaoState state;
    
    public Conexao(ConexaoState conexao){
        this.state = new Desconectado(this);
    }
      
    public void conectar() throws Exception{        
        this.state.conectar();
    }
    
    public void desconectar() throws Exception{
        this.state.desconectar();
    }
    
    public Resposta receberResposta() throws Exception{
       return this.state.receberResposta();
    }
    
    public void enviarRequisicao(Requisicao requisicao) throws Exception{
        this.state.enviarRequisicao(requisicao);
    }
    
    public ConexaoState getState(){
        return this.state;
    }
    
    public void setState(ConexaoState state){
        this.state = state;
    }

}
