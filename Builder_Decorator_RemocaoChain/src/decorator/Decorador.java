/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decorator;

/**
 *
 * @author Josep
 */
public abstract class Decorador extends Sanduiche{
    
    protected Sanduiche elementoDecorado;
    
    public Decorador(Sanduiche elementoDecorado, String descricao, double preco) {
        super(descricao, preco);
        this.elementoDecorado = elementoDecorado;
    }
    
    @Override
    public String getDescricao(){
        return this.elementoDecorado.getDescricao();
    }
    
    @Override
    public double getPreco(){
        return this.elementoDecorado.getPreco();
    }
    
    
    
}
