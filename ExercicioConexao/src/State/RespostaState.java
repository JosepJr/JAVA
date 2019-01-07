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
public class RespostaState extends State {

    public RespostaState(Conexao conexao) {
        super(conexao);
    }
    
    @Override
    public void resposta(Usuario usuario, Resposta resposta){
        resposta.toString();
        System.out.println("Informe 1 para enviar requisicao ou 2 para desconectar: ");
        Scanner ler = new Scanner(System.in);
        int aux = ler.nextInt();
        
        if(aux == 1){ 
            System.out.println("Informe o usuario: ");
            String user = ler.toString();            
            System.out.println("Informe a requisicao: ");
            String req = ler.toString();
            this.conexao.enviarRequisicao(new Usuario(user), new Requisicao(new Usuario(user),req);
        
        }else{
            this.conexao.enviarRequisicao(requisicao);
        }
        
        
    }

}
