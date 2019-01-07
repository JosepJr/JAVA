/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Harrison
 */
public class ProdutoModel implements Comparable<ProdutoModel>, Serializable{
    private String nome;
    private int quantidade;

    public ProdutoModel(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }
    
    @Override
    public String toString(){
        return "" + this.nome + " - " + this.quantidade;
    }

    @Override
    public int compareTo(ProdutoModel t) {
        return nome.compareTo(t.nome);
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
   
}
