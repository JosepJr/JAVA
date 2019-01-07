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
public abstract class Sanduiche {
    protected String descricao;
    protected double preco;

    public Sanduiche(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    public abstract String getDescricao();
    public abstract double getPreco();
   
}
