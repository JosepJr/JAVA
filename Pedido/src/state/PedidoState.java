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
public abstract class PedidoState {
    Pedido pedido;

    public PedidoState(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public void alterar() throws Exception{
        throw new Exception("Pedido não pode ser alterado!");
    }
    
    public void enviar() throws Exception{
        throw new Exception("Pedido não pode ser enviado!");
    }
    
    public void cancelar() throws Exception{
        throw new Exception("Pedido não pode ser cancelado!");
    }
    
}
