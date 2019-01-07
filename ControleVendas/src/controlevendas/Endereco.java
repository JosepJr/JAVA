/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlevendas;

/**
 *
 * @author Josep
 */
public class Endereco {
    
    private String rua;
    private String numero;
    
    public Endereco(String rua, String numero){
        this.rua = rua;
        this.numero = numero;
    }
   
    public String getRua(){
        return this.rua;
    }
    public void setRua(String rua){
        this.rua = rua;
    }

    public String getNumero(){
        return this.numero;
    }
    
    public void setNumero(String numero){
        this.numero = numero;
    }
    
    @Override
    public String toString(){
        return rua +" " + numero;
    }


}
