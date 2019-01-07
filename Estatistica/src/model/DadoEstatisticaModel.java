/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class DadoEstatisticaModel {
    private String dadosEntrada;
    private double media;
    private double variancia;
    private double desvioPadrao;

    public DadoEstatisticaModel(String dadosEntrada, double media, double variancia, double desvioPadrao) {
        this.dadosEntrada = dadosEntrada;
        this.media = media;
        this.variancia = variancia;
        this.desvioPadrao = desvioPadrao;
    }

    public String getDadosEntrada() {
        return dadosEntrada;
    }

    public double getMedia() {
        return media;
    }

    public double getVariancia() {
        return variancia;
    }

    public double getDesvioPadrao() {
        return desvioPadrao;
    }
    
    @Override
    public String toString(){
       
        return "" + getDadosEntrada()+" - "+ String.valueOf(getMedia()) + 
                " - "+ String.valueOf(getVariancia()) + " - " + String.valueOf(getDesvioPadrao());
    }
    
 
}
