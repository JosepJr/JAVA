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
public class MistoQuenteBuilder extends SanduicheBuilder{


    @Override
    public void criarSanduiche() {
        ProcessadorSanduiche.getInstance().getSanduiches().clear();//Limpa o vetor de sanduiches na classe processadora para que eu possa criar mais de um sanduiche
        //na mesma instância.
        this.addPao();
        this.addQueijo();
        this.addPresunto();
    }
    
    
    @Override
    public void addPao(){
        sanduiche = new Decorado("pao", 1.0);
        ProcessadorSanduiche.getInstance().addIngrediente(new Decorado("pao", 1.0));
    }
    
    @Override
    public void addQueijo(){
        sanduiche = new Ingrediente(sanduiche,"mussarela", 1.5);
        ProcessadorSanduiche.getInstance().addIngrediente(new Decorado("mussarela", 1.5));
    }
    
    @Override
    public void addPresunto(){
        sanduiche = new Ingrediente(sanduiche, "presunto", 1.5);        
        ProcessadorSanduiche.getInstance().addIngrediente(new Decorado("presunto", 1.5)); 
    }

}
