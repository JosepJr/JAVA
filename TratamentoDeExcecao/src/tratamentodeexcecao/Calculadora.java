/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamentodeexcecao;


/**
 *
 * @author Josep
 */
public class Calculadora {
    
    public float dividir(int x, int y){
        float resultado = 0;
        try{
            resultado = x/y;
        }
        catch(ArithmeticException erro){
            System.err.println("Divisão por 0, informe outro valor...");
        }   
        return resultado;
    } 
}
