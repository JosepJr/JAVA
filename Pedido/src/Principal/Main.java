/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import model.Pedido;

/**
 *
 * @author Harrison
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Pedido p = new Pedido("Livro");
        try{
        p.enviar();
        
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
}
