/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import questaoconexaomensagemrequisicao.Conexao;

/**
 *
 * @author Josep
 */
public class Desconectado extends ConexaoState {

    public Desconectado(Conexao conexao) {
        super(conexao);
        System.out.println("Desconectado!");
    }

    @Override
    public void conectar() throws Exception {
        this.conexao.setState(new Conectada(conexao));
    }

}
