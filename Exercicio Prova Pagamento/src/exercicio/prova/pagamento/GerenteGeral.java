/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio.prova.pagamento;

/**
 *
 * @author Josep
 */
public class GerenteGeral extends Funcionario{
    
    public GerenteGeral(String nome, boolean disponivel) {
        super(nome, disponivel);
    }

    @Override
    public boolean autoriza(Pagamento pagamento){
        if(pagamento.getValor()<= 1500.00 && this.isDisponivel()){
            pagamento.setRecebeu("Gerente Geral");
            return true;
        }else
            return false;
    }
    
}
