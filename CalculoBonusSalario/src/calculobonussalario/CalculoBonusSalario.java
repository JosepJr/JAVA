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
public class CalculoBonusSalario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Gerente gerente = new Gerente("José Paulo", 1000, 10, "ES", new Bonus("generoso"));
        Programador programador = new Programador("Wagner", 1500, 0, "RJ", new Bonus("normal"));
        Programador p1 = new Programador("aaa", 2812, 10, "SP", new Bonus("aaa"));
        
        
        
        System.out.println(programador.recebeuBonus());
        System.out.println(gerente.recebeuBonus());


        ProcessadoraBonus processa = new ProcessadoraBonus();
        
        processa.processar(programador);        
        System.out.println(programador.toString());
        processa.processar(programador);        
        System.out.println(programador.toString());
    }
    
}
