/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import proxy.ContaCorrenteProxy;

/**
 *
 * @author Josep
 */
public class Proxy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ContaCorrenteProxy ccp = new ContaCorrenteProxy();
        System.out.println("Seu saldo é: " + ccp.getSaldo());
        ccp.depositar(200);
        System.out.println("Seu saldo é: " + ccp.getSaldo());        
        ccp.sacar(100);
        System.out.println("Seu saldo é: " + ccp.getSaldo());
    }
    
}
