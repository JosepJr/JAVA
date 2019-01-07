
package calculobonussalario;

public class AssiduidadeCalculoBonus implements ICalculoBonus{

      
    @Override
    public void calcular(Funcionario funcionario) {         
        for(int i = 0; i < funcionario.bonusRecebidos.size(); i++){    
            if(funcionario.bonusRecebidos.get(i).getNome().equalsIgnoreCase("Assiduidade")){
                if(funcionario.getFaltas() >= 0 && funcionario.getFaltas() <= 1 ){
                    funcionario.getBonusRecebidos().get(i).setValor(funcionario.getSalarioBase()*1.3);
                }
                else{
                    if(funcionario.getFaltas() >= 2 && funcionario.getFaltas() <= 3){
                       funcionario.getBonusRecebidos().get(i).setValor(funcionario.getSalarioBase()*1.2); 
                    }
                    else{
                        if(funcionario.getFaltas() >= 4 && funcionario.getFaltas() <= 5){
                            funcionario.getBonusRecebidos().get(i).setValor(funcionario.getSalarioBase()*1.1);
                        }
                    }
                } 
            }
        }
    }
    @Override
    public boolean merece(Funcionario funcionario) {
        for(int i = 0; i < funcionario.getBonusRecebidos().size(); i++){
            if((funcionario.getBonusRecebidos().get(i).getNome().equalsIgnoreCase("assiduidade")) || (funcionario.getFaltas() >= 6))
                return false;
        }
        funcionario.addBonus(new Bonus("assiduidade"));
        return true;    
    }
}
