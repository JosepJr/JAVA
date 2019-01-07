/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamentodeexcecao;

import java.util.InputMismatchException;
import java.util.Scanner;



/**
 *
 * @author Josep
 */
public class TratamentoDeExcecao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();      
        
        while(true){
            try{
                Scanner ler = new Scanner(System.in);
                int x,y;
                float resultado;

                x = ler.nextInt();
                y = ler.nextInt();

                resultado = calc.dividir(x, y);
                System.out.printf("%.5f\n",resultado);
            }
            catch(InputMismatchException erro){     
                System.err.println("Favor digitar um numero inteiro!");
            }
            finally{
                System.out.println("Cheguei no finally!!!");
                System.exit(0);
            }
            
        }
    }
}
