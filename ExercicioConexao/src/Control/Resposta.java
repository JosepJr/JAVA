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
public class Resposta {
    private String resposta;
    private Usuario remetente;
    
    public Resposta(Usuario remetente, String resposta){
        this.remetente = remetente;
        this.resposta = resposta;
    }

    @Override
    public String toString() {
        return "Resposta{" + "resposta=" + resposta + ", remetente=" + remetente + '}';
    }
    
    
}
