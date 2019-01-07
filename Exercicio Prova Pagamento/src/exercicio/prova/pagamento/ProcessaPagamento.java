/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio.prova.pagamento;

import java.util.ArrayList;

/**
 *
 * @author Josep
 */
public class ProcessaPagamento {
    
    private ArrayList<Funcionario> funcionarios = new ArrayList();
    
    public ProcessaPagamento(){
        this.funcionarios.add(new GerenteImediato("Gerente Imediato",true));
        this.funcionarios.add(new GerenteGeral("Gerente Geral", true));
        this.funcionarios.add(new DiretorFinanceiro("Diretor Financeiro", true));
        this.funcionarios.add(new DiretorGeral("Diretor Geral", true));

    }
    public boolean pagar(Pagamento pagamento){
        for(Funcionario f: funcionarios){
            if(f.autoriza(pagamento)){
                return true;
            }
        }
        return false;
    }
}

