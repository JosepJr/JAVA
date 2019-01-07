/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculobonussalario;

import java.util.ArrayList;

public class ProcessadoraBonus {
    
    private ArrayList <ICalculoBonus> calculosBonus = new ArrayList <>();
    
    public ProcessadoraBonus(){
        this.calculosBonus.add(new NormalCalculoBonus());
        this.calculosBonus.add(new GenerosoCalculoBonus());
        this.calculosBonus.add(new RegiaoCalculoBonus());
        this.calculosBonus.add(new AssiduidadeCalculoBonus());
    }

    public void processar(Funcionario funcionario){
        for(ICalculoBonus c: calculosBonus){
            if(c.merece(funcionario)){
                c.calcular(funcionario);
            }
        }
    }
    
}
