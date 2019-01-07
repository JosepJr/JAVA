/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compositepastaarquivo;

import composite.Arquivo;
import composite.Pasta;

/**
 *
 * @author Josep
 */
public class CompositePastaArquivo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pasta pasta = new Pasta("Projeto de Software",10.0);
        Arquivo arq1 = new Arquivo("prova1", 10.0);
        Arquivo arq2 = new Arquivo("prova2", 10.0);
        Arquivo arq3 = new Arquivo("Prova3", 10.0);
        Pasta pasta2 = new Pasta("Projeto de Software 2",10.0);
        
        pasta.add(arq1);
        pasta2.add(arq2);
        pasta2.add(arq3);
        
        pasta.add(pasta2);
        
        System.out.println(pasta.toString());
        
        
        
        
    }
    
}
