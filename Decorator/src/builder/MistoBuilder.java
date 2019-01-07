/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import decorator.Decorado;
import decorator.Ingrediente;

/**
 *
 * @author Josep
 */
public class MistoBuilder extends SanduicheBuilder{    
   
    public MistoBuilder(){
        this.addPao();
        this.addPresunto();
        this.addMussarela();     
    }
    
    @Override
    public void addPao(){
        sanduiche = new Decorado("Pão Forma", 0.50);
    };
    
    @Override
    public void addPresunto(){
        sanduiche = new Ingrediente(sanduiche, "Presunto", 1.0);
    };
    
    @Override
    public void addMussarela(){
        sanduiche = new Ingrediente(sanduiche, "Mussarela", 1.0);
    };
    
    @Override
    public void addOutro(String nome, double preco){
        sanduiche = new Ingrediente(sanduiche, nome, preco);
    };    
    
    
}
