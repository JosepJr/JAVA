/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composite;

/**
 *
 * @author Josep
 */
public abstract class Componente {
    protected double preco;
    protected String descricao;
    
    public Componente(String descricao, double preco){
        this.descricao = descricao;
        this.preco = preco;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public double getPreco(){
        return this.preco;
    }

    @Override
    public String toString() {
        return "{" + "preco =" + preco + ", descricao =" + descricao + '}';
    }
    
    
}
