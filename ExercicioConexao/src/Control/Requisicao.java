/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Usuario;

/**
 *
 * @author Josep
 */
public class Requisicao {
    private String mensagem;
    private Usuario remetente;
    
    public Requisicao(Usuario remetente, String mensagem){
        this.remetente = remetente;
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "Requisicao{" + "mensagem=" + mensagem + ", remetente=" + remetente + '}';
    }
    
    
}
