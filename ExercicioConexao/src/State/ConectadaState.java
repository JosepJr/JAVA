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
import java.util.Scanner;

/**
 *
 * @author Josep
 */
public class ConectadaState extends State{
    
    
    
    public ConectadaState(Conexao conexao) {
        super(conexao);
    }
    
    
    @Override
    public void conectar(Usuario usuario, Requisicao requisicao){
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Você está conectado, deseja enviar uma requiscao(1) ou desconectar(2): ");
        int aux = ler.nextInt();
        
        if(aux == 1 ){
            this.requisicao(usuario, requisicao);           
        }else{
            this.conexao.desconectar(usuario, requisicao);                    
        }
       
    }
     
    @Override
    public void requisicao(Usuario usuario, Requisicao requisicao){
        System.out.println(requisicao.toString());
        System.out.println("Deseja enviar uma resposta? (1)-sim (2)-nao");
        Scanner ler = new Scanner(System.in);
        int aux = ler.nextInt();
        
        if(aux == 1){
            System.out.println("informe o usuario: ");
            Usuario usuario2 = new Usuario(ler.toString());
            System.out.println("informe a resposta: ");
            String texto = ler.toString();
         this.conexao.receberResposta(usuario, new Resposta(usuario2,texto));
        }
        
        
    }
    
}
