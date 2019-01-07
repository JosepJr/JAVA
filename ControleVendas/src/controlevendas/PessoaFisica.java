/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlevendas;

/**
 *
 * @author Josep
 */
public class PessoaFisica extends Pessoa implements Teste{
    
    private String cpf;
    
    public PessoaFisica(String nome, String matricula, Endereco endereco, String telefone, String nomeContato, String numeroCartao, String email, String cpf) {
        super(nome, matricula, endereco, telefone, nomeContato, numeroCartao, email);
        this.cpf = cpf;  
    }
    
    public PessoaFisica(String nome, Endereco endereco){
        super(nome, endereco);
    }
    
    public String getCpf(){
       return cpf;
   }
   
   public void setCpf(String cpf){
       this.cpf = cpf;
   }

    @Override
    public String toString() {
        return nome +" "+ endereco;
    }

    @Override
    public void testar(String nome) {
        System.out.printf("nome %s", nome);
    }
   
   

}
