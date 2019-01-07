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
public interface IContaCorrenteProxy {
    
    
    public void sacar(double valor);
    public void depositar(double valor);
    public double getSaldo();
    
}
