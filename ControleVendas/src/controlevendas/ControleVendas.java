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
public class ControleVendas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Endereco endereco = new Endereco("aaaaaAAaa","123");
        PessoaFisica pessoa = new PessoaFisica("josé paulo" , endereco);
        System.out.printf(pessoa.toString());
        System.out.println(pessoa.getEndereco().toString());
        
        pessoa.testar("Teste interfaces");
        
    }
    
}
