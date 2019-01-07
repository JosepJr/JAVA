/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porta;

import State.Aberta;
import model.Porta;

/**
 *
 * @author Aluno
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Porta p = new Porta();

        p.destrancar();
        p.abrir();
        p.fechar();

    }

}
