/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiposdedados;
import java.util.Scanner;
/**
 *
 * @author Josep
 */
public class TiposDeDados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Criando Variáveis Normais parecido com C
        int a = 3;
        float a1 = 3.3212f;
        char a2 = 'a';
        boolean a3 = false;
        //Usando Typecast o programa obriga que seja inteiro. Ou Real.
        int b = (int) 3;
        float b1 = (float) 3.3212; 
        char b2 = (char) 'a';
        boolean b3 = false;
        
        Scanner ler = new Scanner(System.in);
                
        System.out.print("Informe o nome da pessoa: ");
        String nome = ler.nextLine();
        System.out.print("Informe a nota da pessoa: ");
        float nota = ler.nextFloat(); //nextShot, nextByte, nextFloat, nextDouble
                    
        System.out.printf("Nome: %s", nome);
        System.out.println("");
        System.out.printf("Nota: %.4f", nota);
        System.out.println("");
        
        //Converter nuumero para String toString
        int teste = ler.nextInt();
        nome = Integer.toString(teste);        
        System.out.printf("%s", nome);
        
        System.out.println("");
        
        String teste2 = "30";
        int lol = Integer.parseInt(teste2);
        System.out.printf("%d", lol);
        System.out.println("");
        
        String teste3 = "3.4";
        float lol2 = Float.parseFloat(teste3);
        System.out.printf("%f", lol2);
        System.out.println("");
        
        
        //random de 10 a 5, se quiser sem o 10 a 5 tem que tirar o (10 - 5) ai da de 0 a 1
        
        double ale = Math.random();
        int n = (int) (5 + ale *(10-5));
        System.out.println(n);
        
        //Arredondamento floor = baixo, cima = ceil, cima ou baixo = round. 
        float v = 8.3f;
        int ar = (int) Math.floor(v);
        System.out.println(ar);
        
        
    }
    
}
