/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import decorator.Decorado;
import decorator.Ingrediente;
import decorator.Sanduiche;
import java.util.ArrayList;

/**
 *
 * @author Josep
 */
public class Diretor {
    private final SanduicheBuilder builder;
    
    public Diretor(SanduicheBuilder builder){
        this.builder = builder;
    }
    
    public Sanduiche build(ArrayList<String> ingredientesRemover){        
        builder.criarSanduiche();        
        return this.construirSanduicheEditado(ingredientesRemover);
    }
    
    public Sanduiche build(){
        builder.criarSanduiche();                
        return this.builder.getSanduiche();
    }
    
    private Sanduiche construirSanduicheEditado(ArrayList<String> ingredientesRemover){
        Sanduiche sanduicheEditado;
        ArrayList<Decorado> ingredientes =  ProcessadorSanduiche.getInstance().removerIngrediente(ingredientesRemover);        
        sanduicheEditado = new Decorado(ingredientes.get(0).getDescricao(), ingredientes.get(0).getPreco());
        for(int i = 1; i < ingredientes.size(); i++){
            sanduicheEditado = new Ingrediente(sanduicheEditado, ingredientes.get(i).getDescricao(), ingredientes.get(i).getPreco());
        }        
        return sanduicheEditado;
        
    }
}
