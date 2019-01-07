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
public class Resposta {
    private String resposta;
    private Usuario remetente;
    
    public Resposta(Usuario rementente, String resposta){
        this.remetente = rementente;
        this.resposta = resposta;
    }

    public String getResposta() {
        return this.resposta;
    }

    public Usuario getRemetente() {
        return this.remetente;
    } 
}
