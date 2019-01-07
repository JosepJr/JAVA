/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Harrison
 */
public class Lampada implements IDispositivo{

    public Lampada() {
    }

    @Override
    public void ligar() {
        System.out.println("Lâmpada acesa!");
    }
    
}
