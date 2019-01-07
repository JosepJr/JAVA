/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import questaoconexaomensagemrequisicao.Conexao;
import questaoconexaomensagemrequisicao.Requisicao;
import questaoconexaomensagemrequisicao.Resposta;

/**
 *
 * @author Josep
 */
public class AguardandoResposta extends ConexaoState {

    public AguardandoResposta(Conexao conexao, Requisicao requisicao) {
        super(conexao);
        System.out.println("Requsicao enviada: " + requisicao.getResposta() + ", do usuário: " + requisicao.getRemetente().getNome());
    }
    
    @Override
    public Resposta receberResposta(){
        
    }
    
}
