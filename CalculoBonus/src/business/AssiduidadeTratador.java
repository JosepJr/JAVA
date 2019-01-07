/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import model.Funcionario;

/**
 *
 * @author Harrison
 */
public class AssiduidadeTratador implements BonusTratador {

    @Override
    public double calcular(Funcionario f) {
        if (f.getFaltas() == 0) {
            return f.getSalarioBase() * 1.2;
        } else if (f.getFaltas() >= 0 && f.getFaltas() <= 5) {
            return f.getSalarioBase() * 1.15;
        } else if (f.getFaltas() >= 5 && f.getFaltas() <= 10) {
            return f.getSalarioBase() * 1.10;
        } else {
            return f.getSalarioBase();
        }
    }

    @Override
    public boolean aceitar(Funcionario f) {
        for (String n : f.getBonusRecebidos()) {
            if (n.equals("assiduidade")) {
                return false;
            }

        }
        return true;
    }

}
