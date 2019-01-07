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
public class Diretor {
    private SanduicheBuilder builder;
    
    
    public Diretor(SanduicheBuilder builder){
        this.builder = builder;
    }
    
    public Sanduiche build(){
        return this.builder.getSanduiche();
    }
        
    
    
}
