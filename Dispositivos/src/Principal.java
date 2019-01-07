/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Harrison
 */
public class Principal {
    public static void main(String[] args){
        IDispositivo lampada = new Lampada();
        Botao botao = new Botao(lampada);
        botao.ligar();
    }
}
