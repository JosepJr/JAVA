/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcularmedia;

import java.util.Scanner;

/**
 *
 * @author Josep
 */
public class CalcularMedia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner ler = new Scanner (System.in);
        int n1 = ler.nextInt();
        int n2 = ler.nextInt();
        float media = (n1+n2)/2;
        System.out.printf("Média é: %.2f", media);
        if(media >= 7){
            System.out.println("Você passou, parabens!!!");
        }
        else{
            System.out.println("Infelizmente você não atingiu a nota para passar!");
        }
        
        // TODO code application logic here
    }
    
}
