/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composite;

import java.util.ArrayList;

/**
 *
 * @author Josep
 */
public class Pasta extends ArquivoComposite{

    protected ArrayList<ArquivoComposite> arquivos;
    
    public Pasta(String descricao, double tamanho) {
        super(descricao, tamanho);
        this.setTipo("Pasta");
        arquivos = new ArrayList<>();
        
    }
    
    public Pasta add(ArquivoComposite composite){
        arquivos.add(composite);
        return this;
    }

    @Override
    public String getDescricao() {
        for(ArquivoComposite arquivo: arquivos){
            this.descricao +=" ," + arquivo.getDescricao() +" ("+ arquivo.getTipo() +")";
        }
        return this.descricao;
    }

    @Override
    public double getTamanho() {
        for(ArquivoComposite arquivo: arquivos){
            this.tamanho += arquivo.getTamanho();
        }
        return this.tamanho; 
    }
    
    @Override
    public String toString(){
        return "Nome da pasta: " + this.getDescricao() + "\nTamanho Total: " + this.getTamanho();
    }
    
}
