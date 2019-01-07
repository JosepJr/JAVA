/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

import model.Pedido;

/**
 *
 * @author Harrison
 */
public class Processando extends PedidoState{
    
    public Processando(Pedido pedido) {
        super(pedido);
    }
    
    @Override
    public void alterar() throws Exception{
        pedido.setState(new Processando(pedido));
        System.out.println("Estado Processando...");
    }
    
    @Override
    public void enviar() throws Exception{
        pedido.setState(new Enviado(pedido));
        System.out.println("Estado Enviado...");
    }
    
    @Override
    public void cancelar() throws Exception{
        pedido.setState(new Cancelado(pedido));
        System.out.println("Estado Cancelado...");
    }
    
}
