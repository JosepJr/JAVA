/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import proxy.ImagemProxy;

/**
 *
 * @author Josep
 */
public class QuestãoProxyImagemProva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<ImagemProxy> imagens = new ArrayList<>();
        imagens.add(new ImagemProxy("Imagem1_10Mb.jpg"));
        imagens.add(new ImagemProxy("Imagem2_10Mb.jpg"));
        imagens.add(new ImagemProxy("Imagem3_10Mb.jpg"));
        imagens.add(new ImagemProxy("Imagem4_10Mb.jpg"));        
        imagens.add(new ImagemProxy("Imagem5_10Mb.jpg"));
        
        imagens.get(0).exibir();
        imagens.get(1).exibir();
        imagens.get(0).exibir();
        imagens.get(2).exibir();
        imagens.get(1).exibir();
        
        
        
        
    }
    
}
