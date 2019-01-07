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
public class RegiaoCalculoBonus implements ICalculoBonus{

    @Override
    public void calcular(Funcionario funcionario) {        
        for(int i = 0; i < funcionario.getBonusRecebidos().size(); i++){
            if(funcionario.getBonusRecebidos().get(i).getNome().equalsIgnoreCase("Regiao")){    
                if(funcionario.getEstado().equalsIgnoreCase("ES")){
                    funcionario.getBonusRecebidos().get(i).setValor(funcionario.getSalarioBase()*0.15);
                }
                if(funcionario.getEstado().equalsIgnoreCase("SP")){
                    funcionario.getBonusRecebidos().get(i).setValor(funcionario.getSalarioBase()*0.25);
                }
                if(funcionario.getEstado().equalsIgnoreCase("RJ")){
                    funcionario.getBonusRecebidos().get(i).setValor(funcionario.getSalarioBase()*0.20);
                }
            }
        }
    }

    @Override
    public boolean merece(Funcionario funcionario) {
       for(int i = 0; i < funcionario.getBonusRecebidos().size(); i++){
            if(funcionario.getBonusRecebidos().get(i).getNome().equalsIgnoreCase("Regiao")){
                return false;
            }
        }
        return true;
    }    
    
}
