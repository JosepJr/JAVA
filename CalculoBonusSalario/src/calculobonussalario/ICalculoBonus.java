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
public interface ICalculoBonus {

    
    
    public void calcular(Funcionario funcionario);
    public boolean merece(Funcionario funcionario);
    
}
