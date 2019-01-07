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
public class Ingrediente extends Decorador{

    public Ingrediente(Sanduiche componente, String descricao, double preco) {
        super(componente, descricao, preco);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao()+", "+ this.descricao;
    }

    @Override
    public double getPreco() {
        return super.getPreco()+this.preco;
    }
    
}
