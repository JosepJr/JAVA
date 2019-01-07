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
public class GenerosoCalculoBonus implements ICalculoBonus{

    @Override
    public void calcular(Funcionario funcionario) {        
        for(int i = 0; i < funcionario.getBonusRecebidos().size(); i++){
            if(funcionario.getBonusRecebidos().get(i).getNome().equalsIgnoreCase("generoso")){
                funcionario.getBonusRecebidos().get(i).setValor(funcionario.getSalarioBase()*1.50);
            }
        }
    }

    @Override
    public boolean merece(Funcionario funcionario) {
       for(int i = 0; i < funcionario.getBonusRecebidos().size(); i++){
            if(funcionario.getBonusRecebidos().get(i).getNome().equalsIgnoreCase("generoso") || funcionario.getBonusRecebidos().get(i).getNome().equalsIgnoreCase("normal")){
                return false;
            }
        }
        return true;
    }    
}
