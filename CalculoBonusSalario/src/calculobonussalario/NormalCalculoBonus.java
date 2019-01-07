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
public class NormalCalculoBonus implements ICalculoBonus{

    @Override
    public void calcular(Funcionario funcionario) {        
        for(int i = 0; i < funcionario.getBonusRecebidos().size(); i++){
            if(funcionario.getBonusRecebidos().get(i).getNome().equalsIgnoreCase("normal")){
                funcionario.getBonusRecebidos().get(i).setValor(funcionario.getSalarioBase()*1.3);
            }
        }
    }

    @Override
    public boolean merece(Funcionario funcionario) {
       for(int i = 0; i < funcionario.getBonusRecebidos().size(); i++){
            if(funcionario.getBonusRecebidos().get(i).getNome().equalsIgnoreCase("normal") || funcionario.getBonusRecebidos().get(i).getNome().equalsIgnoreCase("generoso")){
                return false;
            }
        }
        return true;
    }    
}
