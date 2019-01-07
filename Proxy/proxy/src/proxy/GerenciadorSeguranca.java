/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

/**
 *
 * @author Josep
 */
public class GerenciadorSeguranca {
    private final int senha = 1234;
    private final int conta = 1000;

    public boolean autorizar(int conta, int senha){
        if(this.senha == senha && this.conta == conta){
            System.out.println("Transação Autorizada!");
            return true;
        }
        System.out.println("Transação não Autorizada!!!!");
        return false;
    }
    
}
