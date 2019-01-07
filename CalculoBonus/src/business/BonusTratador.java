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
public interface BonusTratador {
    public double calcular(Funcionario f);
    public boolean aceitar(Funcionario f);

}
