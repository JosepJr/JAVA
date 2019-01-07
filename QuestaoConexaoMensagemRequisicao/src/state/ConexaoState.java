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
public class ConexaoState {

    protected Conexao conexao;

    public ConexaoState(Conexao conexao) {
        this.conexao = conexao;
    }

    public void conectar() throws Exception {
        throw new Exception("Não é possível conectar. ");
    }

    public void desconectar() throws Exception {
        throw new Exception("Não é possível desconectar. ");
    }

    public Resposta receberResposta() throws Exception {
        throw new Exception("Não é possível receber resposta. ");
    }

    public void enviarRequisicao(Requisicao requisicao) throws Exception {
        throw new Exception("Não é possível enviar requisicao. ");
    }

}
