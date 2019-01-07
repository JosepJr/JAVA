/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculobonussalario;

/**
 *
 * @author Josep
 */
public class Bonus {
    private String nome;
    private double valor;
            
    public Bonus (String nome){
        this.nome = nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
   
    public String getNome(){
        return this.nome;
    }

    public void setValor(double valor){
        this.valor = valor;
    }

    public double getValor(){
        return this.valor;
    }

    @Override
    public String toString() {
        return "Bonus{" + "nome=" + nome + ", valor=" + valor + '}';
    }
   
}

