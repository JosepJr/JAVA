/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacaixaeletronico;

/**
 *
 * @author Josep
 */
public abstract class Cedula {
    private int quantidade = 0;
    private double valor = 0;
        
    public Cedula(double valor, int quantidade){
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public void subtrair(){
            this.quantidade--;
    }
    
    public void adicionar(int quantidade){
        this.quantidade = this.quantidade + quantidade;
    }
        
    public int getQuantidade(){
       return this.quantidade;
   }

    public double getValor(){
        return this.valor;
    }
    
}
