/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import model.Funcionario;

/**
 *
 * @author Aluno
 */
public class NormalTratador implements BonusTratador {

    @Override
    public double calcular(Funcionario f) {
        return f.getSalarioBase() * 1.05;
    }

    @Override
    public boolean aceitar(Funcionario f) {
        for (String n : f.getBonusRecebidos()) {
            if (n.equals("normal") && n.equals("generoso")) {
                return false;

            }
        }
        return true;
    }
}
