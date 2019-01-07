/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uec;

/**
 *
 * @author Josep
 */
public class UEC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lutador lutador[] = new Lutador[6];
        lutador[0] = new Lutador("Pretty Boy","Franca", 31, 1.75f,68.9f,11,2,1);
        //lutador[0].apresentar();
        //System.out.println("");
        lutador[1] = new Lutador("Putscript","Brasil", 29, 1.68f, 57.8f,14,2,3);
        //lutador[1].apresentar();
        //System.out.println("");
        lutador[2] = new Lutador("Snapshadow","EUA", 35, 1.65f, 80.9f,12,2,1);
        //lutador[2].apresentar();
        //System.out.println("");
        lutador[3] = new Lutador("UFOCobol","Brasil", 37, 1.70f, 119.3f,5,4,3);
        //lutador[3].apresentar();
        //System.out.println("");
        lutador[4] = new Lutador("Nerdaart","EUA", 30, 1.81f, 105.7f,12,2,4);
        //lutador[4].apresentar();
        
        
        Luta UEC01 = new Luta();
        UEC01.marcarLuta(lutador[1],lutador[4]);
        UEC01.lutar();
        System.out.println("Resultados após as lutas....");
        lutador[0].apresentar();
        System.out.println("");
        lutador[1].apresentar();
        
    }
    
}
