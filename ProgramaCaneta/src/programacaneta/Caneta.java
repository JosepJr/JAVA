/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacaneta;

import java.util.Scanner;

/**
 *
 * @author Josep
 */
public class Caneta {
    private String modelo;
    String cor;
    Boolean tampada;
    float ponta;
    int carga;
        
    public Caneta(String modelo, String cor, Boolean tampada, float ponta, int carga) {
        this.modelo = modelo;
        this.cor = cor;
        this.tampada = tampada;
        this.ponta = ponta;
        this.carga = carga;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Boolean getTampada() {
        return tampada;
    }

    public void setTampada(Boolean tampada) {
        this.tampada = tampada;
    }

    public float getPonta() {
        return ponta;
    }

    public void setPonta(float ponta) {
        this.ponta = ponta;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }
    
    
    
    void status(){
        System.out.printf("Uma caneta %s\n", this.cor);
        System.out.printf("Modelo:  %s\n", this.modelo);
        System.out.printf("Com a ponta: %.1f\n", this.ponta);
        System.out.printf("Sua carga está em: %d\n", this.carga);
        if(tampada = true){
            System.out.println("Sua caneta está tampada!");
            System.out.println("Se deseja destampa-la? Informe 1 para e 2 para não... ");
            Scanner ler = new Scanner(System.in);
            int aux = ler.nextInt();
            if(aux == 1){
                this.destampar(aux);
            }
        }
        else{
            System.out.println("Sua caneta não esta tampada... ");
            System.out.println("Se deseja tampar, informe 1 para tampa-lá e 2 para não... ");
            Scanner ler = new Scanner(System.in);
            int aux = ler.nextInt();
            if(aux == 1){
                this.tampar(aux);
            }
        }
    }
    
    void rabiscar (){
        if(this.tampada == true){
            System.out.println("Erro!!! A caneta está tampada, não posso rasbicar!");
        }
        else{
            System.out.println("Rasbicando....");
        }
    }   
    
    void tampar(int aux){
        this.tampada = true;    
    }
    
    void destampar(int aux){
        this.tampada = false;
    
    }
}
