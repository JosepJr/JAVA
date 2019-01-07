/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import builder.CheeseBurgerBuilder;
import builder.Diretor;
import builder.MistoQuenteBuilder;
import decorator.Ingrediente;
import decorator.Sanduiche;
import java.util.ArrayList;

/**
 *
 * @author Josep
 */
public class Questao61 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        
        ArrayList<String> elementosRemover = new ArrayList<>();
        elementosRemover.add("mussarela");
        elementosRemover.add("ovo");
        
        
        //-------------------------------MISTO QUENTE----------------------------------------------------------------
        System.out.println("CONTRUINDO MISTO QUENTE COMPLETO");
        Diretor diretor = new Diretor(new MistoQuenteBuilder());
        Sanduiche sanduiche = diretor.build();
        System.out.println("Seu lanche COMPLETO: " + sanduiche.getDescricao() + "\nO preço é: R$ " + sanduiche.getPreco() +"\n");

        System.out.println("CONTRUINDO MISTO QUENTE EDITADO");
        Sanduiche sanduiche2 = diretor.build(elementosRemover);
        System.out.println("Seu lanche EDITADO: " + sanduiche2.getDescricao() + "\nO preço é: R$ " + sanduiche2.getPreco() +"\n");
        
        //ADICIONANDO INGREDIENTES
        System.out.println("ADICIONANDO INGREDIENTES AO MISTO QUENTE COMPLETO");
        sanduiche = new Ingrediente(sanduiche, "Ovo", 2.00);
        sanduiche = new Ingrediente(sanduiche, "Mussarela", 2.00);
        System.out.println("Seu lanche COMPLETO com incrementos é: " + sanduiche.getDescricao() + "\nO preço é: R$ " + sanduiche.getPreco()+"\n");
        
        System.out.println("ADICIONANDO INGREDIENTES AO MISTO QUENTE EDITADO");
        sanduiche2 = new Ingrediente(sanduiche2, "Ovo", 2.00);
        sanduiche2 = new Ingrediente(sanduiche2, "Mussarela", 2.00);
        System.out.println("Seu lanche EDITADO com incrementos é: " + sanduiche2.getDescricao() + "\nO preço é: R$ " + sanduiche2.getPreco()+"\n");

        
        //-----------------------------------------------------------------------------------------------------------------
        
        
        //-----------------------------CHEESE BURGUER-----------------------------------------------------------------------
        System.out.println("CONTRUINDO CHEESEBURGUER COMPLETO");
        Diretor diretor2 = new Diretor(new CheeseBurgerBuilder());
        Sanduiche sanduiche3 = diretor2.build();
        System.out.println("Seu lanche COMPLETO: " + sanduiche3.getDescricao() + "\nO preço é: R$ " + sanduiche3.getPreco() +"\n");

        System.out.println("CONTRUINDO CHEESEBURGUER EDITADO");
        Sanduiche sanduiche4 = diretor2.build(elementosRemover);
        System.out.println("Seu lanche EDITADO: " + sanduiche4.getDescricao() + "\nO preço é: R$ " + sanduiche4.getPreco() +"\n");
        
        
        //ADICIONANDO INGREDIENTES
        System.out.println("ADICIONANDO INGREDIENTES AO CHEESEBURGUER COMPLETO");
        sanduiche3 = new Ingrediente(sanduiche3, "Tomate", 2.00);
        sanduiche3 = new Ingrediente(sanduiche3, "peperone", 2.00);
        System.out.println("Seu lanche COMPLETO com incrementos é: " + sanduiche3.getDescricao() + "\nO preço é: R$ " + sanduiche3.getPreco()+"\n");
        
        System.out.println("ADICIONANDO INGREDIENTES AO CHEESEBURGUER EDITADO");
        sanduiche4 = new Ingrediente(sanduiche4, "BarbieCue", 2.00);
        sanduiche4 = new Ingrediente(sanduiche4, "peperone", 2.00);
        System.out.println("Seu lanche EDITADO com incrementos é: " + sanduiche4.getDescricao() + "\nO preço é: R$ " + sanduiche4.getPreco()+"\n");
        
       
        //-----------------------------------------------------------------------------------------------------------------
          
    }

}
