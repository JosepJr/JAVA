/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composite;

import java.util.ArrayList;

/**
 *
 * @author Josep
 */
public class Todo extends Componente{  
    protected ArrayList<Componente> componentes;
    
    public Todo(String descricao, double preco) {
        super(descricao, preco);
        componentes = new ArrayList<>();
    }
    
    @Override
    public String getDescricao(){
        for(Componente c : componentes){
            this.descricao +=", " + c.getDescricao() +", ";
        }        
        return this.descricao;
    }
    
    @Override
    public double getPreco(){
        for(Componente c : componentes){
            this.preco += c.getPreco();
        }        
        return this.preco;
    }
        
    public Todo add(Componente componente){
        this.componentes.add(componente);
        return this;
    }
          
    @Override
    public String toString(){
        return this.getDescricao() + ", TOTAL: " + this.getPreco();
    }
    
}
