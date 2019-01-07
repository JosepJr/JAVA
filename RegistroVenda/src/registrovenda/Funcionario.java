/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registrovenda;

/**
 *
 * @author Josep
 */
public abstract class  Funcionario {
    private String nome;
    private boolean disponivel;
   
    
    void setNome(String nome){
        this.nome = nome;
    }
        
}
