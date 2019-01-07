/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import questaoconexaomensagemrequisicao.Conexao;
import questaoconexaomensagemrequisicao.Requisicao;

/**
 *
 * @author Josep
 */
public class Conectada extends ConexaoState {

    public Conectada(Conexao conexao) {
        super(conexao);
        System.out.println("Conectado!");
    }
    
    @Override
    public void enviarRequisicao(Requisicao requisicao) throws Exception{
        this.conexao.setState(new AguardandoResposta(conexao, requisicao));
    }
    
}
