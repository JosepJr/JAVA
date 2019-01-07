/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculobonussalario;

/**
 *
 * @author Josep
 */
public class Gerente extends Funcionario{
    public Gerente(String nome, double salarioBase, int faltas, String estado, Bonus bonus){
        super(nome, salarioBase,faltas, estado, bonus);
    }
 
}
