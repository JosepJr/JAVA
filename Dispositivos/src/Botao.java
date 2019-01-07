/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Harrison
 */
public class Botao {
    private IDispositivo dispositivo;
    
    public Botao(IDispositivo dispositivo){
        this.dispositivo = dispositivo;
    }
    
    public void ligar(){
        dispositivo.ligar();
    }
}
