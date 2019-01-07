/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

import java.util.Scanner;

/**
 *
 * @author Josep
 */
public class ContaCorrenteProxy implements IContaCorrenteProxy{

    private ContaCorrente contaReal;
    private GerenciadorSeguranca gerenciadorSeguranca;
    
    public ContaCorrenteProxy(){
        this.contaReal = new ContaCorrente();
        this.gerenciadorSeguranca = new GerenciadorSeguranca();
    }
    
    @Override
    public void sacar(double valor) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Por favor, informe o numero da conta!");        
        int conta = ler.nextInt();       
        System.out.println("Por favor, informe sua senha!");
        int senha = ler.nextInt();       
        if(this.gerenciadorSeguranca.autorizar(conta, senha)){
            this.contaReal.sacar(valor);
        }
        
    }

    @Override
    public void depositar(double valor) {
        this.contaReal.depositar(valor);
    }

    @Override
    public double getSaldo() {
        Scanner ler = new Scanner(System.in);
        System.out.println("Por favor, informe o numero da conta!");        
        int conta = ler.nextInt();       
        System.out.println("Por favor, informe sua senha!");
        int senha = ler.nextInt();       
        if(this.gerenciadorSeguranca.autorizar(conta, senha)){
            return this.contaReal.getSaldo();
        }
        return 0;
    }
    
}
