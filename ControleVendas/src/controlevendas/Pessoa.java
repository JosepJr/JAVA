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
public abstract class Pessoa {
    
    protected String nome;
    private String matricula;
    protected Endereco endereco;
    private String telefone;
    private String nomeContato;
    private String numeroCartao;
    private String email;
    
    public Pessoa(String nome, String matricula, Endereco endereco, String telefone, String nomeContato, String numeroCartao, String email){
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.endereco = endereco;
        this.nomeContato = nomeContato;
        this.numeroCartao = numeroCartao;
        this.telefone = telefone;
    }
    
     public Pessoa(String nome, Endereco endereco){
        this.nome = nome;
        this.endereco = endereco;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getMatricula(){
        return matricula;
    }
    
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
}
