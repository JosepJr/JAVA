/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import decorator.Sanduiche;

/**
 *
 * @author Josep
 */
public abstract class SanduicheBuilder {
    protected Sanduiche sanduiche;

    public final Sanduiche getSanduiche() {
        return this.sanduiche;
    }
 
    public abstract void criarSanduiche();

    public void addPao(){};
    public void addCarne(){};
    public void addQueijo(){};
    public void addPresunto(){};
    
}
