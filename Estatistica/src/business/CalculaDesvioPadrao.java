/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;

/**
 *
 * @author Harrison
 */
public class CalculaDesvioPadrao implements Estatistica {

    @Override
    public double calcula(ArrayList<String> dados) {

        double media = 0;
        for (int i = 0; i < dados.size(); i++) {
            media += Double.parseDouble(dados.get(i));
        }
        media = media / dados.size();
        double somatorio = 0;
        for (int i = 0; i < dados.size(); i++) {
            double result = Double.parseDouble(dados.get(i)) - media;
            somatorio = somatorio + result * result;
        }
        return Math.sqrt(((double) 1 / (dados.size() - 1))
                * somatorio);

    }
}
