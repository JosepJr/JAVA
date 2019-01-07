/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import builder.Diretor;
import builder.MistoBuilder;
import decorator.Decorado;
import decorator.Ingrediente;
import decorator.Sanduiche;

/**
 *
 * @author Josep
 */
public class BuilderDecorator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Diretor d = new Diretor(new MistoBuilder());
        Sanduiche sanduiche = d.build();
        
        System.out.println(sanduiche.getDescricao());
        System.out.println(sanduiche.getPreco());
        
    }
    
}
