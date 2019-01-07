/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Usuario;
import State.ConectadaState;
import State.RespostaState;
import State.State;
import java.util.Scanner;

/**
 *
 * @author Josep
 */
public class Conexao {
    
    private State state;

    
    public Conexao(Usuario usuario, Requisicao requisicao){
        this.desconectar(usuario, requisicao);
    }
    
    public void conectar(){
    
    }
    
    public void desconectar(Usuario usuario, Requisicao requisicao){
        Scanner ler = new Scanner(System.in);
        System.out.println("Deseja se conectar? 1-sim, 2-nao");
        int aux = ler.nextInt();
        if(aux == 1){
            this.setState(new ConectadaState(this));
            this.state.conectar(usuario, requisicao);
        }else{
            this.desconectar(usuario, requisicao);            
        }
    }
    
    public void enviarRequisicao(Requisicao requisicao){
        
    }

    public void receberResposta(Usuario usuario, Resposta resposta){
        this.setState(new RespostaState(this));
        this.state.resposta(usuario, resposta); 
       
    }
    
    public void setState(State state){
        this.state = state;
    }
    
    
}
