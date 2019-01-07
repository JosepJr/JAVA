/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questaoconexaomensagemrequisicao;

/**
 *
 * @author Josep
 */
public class Requisicao {
    
    private String mensagem;
    private Usuario remetente;
    
    public Requisicao(Usuario rementente, String mensagem){
        this.remetente = rementente;
        this.mensagem = mensagem;
    }

    public String getResposta() {
        return this.mensagem;
    }

    public Usuario getRemetente() {
        return this.remetente;
    } 
    
}
