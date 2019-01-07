/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import business.ProcessadorBonus;
import model.Funcionario;
import model.Programador;
/**
 *
 * @author Aluno
 */
public class ClienteMain {

    public static void main(String[] args) {
     
        Funcionario f = new Programador("José", 35, 1000, 4);
        f.processar(f);
        System.out.println(f);
    }
}
