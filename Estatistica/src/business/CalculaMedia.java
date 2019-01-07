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
public class CalculaMedia implements Estatistica {

    @Override
    public double calcula(ArrayList<String> dados) {

        double media = 0;
        for (int i = 0; i < dados.size(); i++) {
            media += Double.parseDouble(dados.get(i));
        }
        return media / dados.size();
    }

}
