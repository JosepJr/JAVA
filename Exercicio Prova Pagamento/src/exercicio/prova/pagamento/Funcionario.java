/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio.prova.pagamento;

public abstract class Funcionario {
    private String nome;
    private boolean disponivel;
    
    public Funcionario(String nome, boolean disponivel){
        this.nome = nome;
        this.disponivel = disponivel;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return this.nome;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public abstract boolean autoriza(Pagamento pagamento);
}


