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
public class ImagemProxy implements IImagemProxy{

    private String nomeArquivo;
    private Imagem imagemReal;

    public ImagemProxy(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        System.out.println("Exibindo a miniatura da imagem " + nomeArquivo);
    }
    
        
    @Override
    public void exibir() {
        if(this.imagemReal == null){
            this.imagemReal = new Imagem(this.nomeArquivo);
        }
        this.imagemReal.exibir();
    }
}
