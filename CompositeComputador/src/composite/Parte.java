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
public class Parte extends Componente{
    
    public Parte(String descricao, double preco) {
        super(descricao, preco);
    }
    
    @Override
    public String getDescricao(){
        return this.descricao;
    }
    
    @Override
    public double getPreco(){
        return this.preco;
    }
}
