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
public class Cancelado extends PedidoState{
    
    public Cancelado(Pedido pedido) {
        super(pedido);
    }
    
    
}
