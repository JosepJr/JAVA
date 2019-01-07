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
public abstract class ArquivoComposite {
    protected String descricao;
    protected double tamanho;
    protected String tipo;
    
    public ArquivoComposite(String descricao, double tamanho){
        this.descricao = descricao;
        this.tamanho = tamanho;
    }
    
    public abstract String getDescricao();
    
    public abstract double getTamanho();
    
    public String getTipo(){
        return this.tipo;
    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    @Override
    public String toString(){
        return "Nome: " + this.getDescricao() +", Tamanho: " + this.getTamanho();
    }
}
