/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proxy;

/**
 *
 * @author Josep
 */
public class Imagem implements IImagemProxy{

    private String nomeArquivo;
    
    public Imagem(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
        this.carregarDisco();
    }
    
    @Override
    public void exibir() {
        System.out.println("Exibindo a imagem " + this.nomeArquivo);
    }
    
    public void carregarDisco(){
        System.out.println("Carregando a imagem " + this.nomeArquivo);
    }
    
}
