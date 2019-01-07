/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import state.PedidoState;
import state.Processando;

/**
 *
 * @author Harrison
 */
public class Pedido {

    private PedidoState estado;
    private String nome;

    public Pedido(String nome) {
        this.nome = nome;
        this.setState(new Processando(this));
    }

    public void alterar() throws Exception {
        estado.alterar();
    }

    public void cancelar() throws Exception {
        estado.cancelar();
    }

    public void enviar() throws Exception {
        estado.enviar();
    }

    public void setState(PedidoState state) {
        this.estado = state;
    }
}
