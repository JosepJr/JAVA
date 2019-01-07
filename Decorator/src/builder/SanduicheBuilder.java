/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import decorator.Decorado;
import decorator.Sanduiche;

/**
 *
 * @author Josep
 */
public abstract class SanduicheBuilder {
    protected Sanduiche sanduiche;
    

    
    public final Sanduiche getSanduiche(){
        return this.sanduiche;
    }
    
    public void addPao(){};
    public void addBife(){};
    public void addAlface(){};    
    public void addTomate(){};
    public void addBatata(){};
    public void addOvo(){};
    public void addPresunto(){};
    public void addMussarela(){};
    public void addOutro(String nome, double valor){};    
    
}
