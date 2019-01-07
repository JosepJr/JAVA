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
public class CheeseBurgerBuilder extends SanduicheBuilder{
    
    @Override
    public void criarSanduiche() {
        ProcessadorSanduiche.getInstance().getSanduiches().clear();//Limpa o vetor de sanduiches na classe processadora para que eu possa criar mais de um sanduiche
        //na mesma instância.
        this.addPao();
        this.addCarne();
        this.addQueijo();        
    }
    
    @Override
    public void addPao(){
        sanduiche = new Decorado("pao", 3.00);
        ProcessadorSanduiche.getInstance().addIngrediente(new Decorado("pao", 3.00));
    }
    
    @Override
    public void addCarne(){
        sanduiche = new Ingrediente(sanduiche, "bife boi", 2.00);
        ProcessadorSanduiche.getInstance().addIngrediente(new Decorado("bife boi", 2.00));
    }
    
    @Override
    public void addQueijo(){
        sanduiche = new Ingrediente(sanduiche, "mussarela", 2.00);
        ProcessadorSanduiche.getInstance().addIngrediente(new Decorado("mussarela", 2.00));
    }
    
}
