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
public class Arquivo extends ArquivoComposite{

    public Arquivo(String descricao, double tamanho) {
        super(descricao, tamanho);
        this.setTipo("Arquivo");
    }

    @Override
    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public double getTamanho() {
        return this.tamanho;
    }
    
    @Override
    public String toString(){
        return "Nome do Arquivo: " + this.getDescricao() +"\n Tamanho total: " + this.getTamanho();
    }
    
}
