/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import model.Porta;

/**
 *
 * @author Aluno
 */
public class TrancarCommand implements PortaCommand{

    @Override
    public void executar(Porta p) {
        System.out.println("Porta sendo trancada...");
        System.out.println("Porta trancada.");
    }
    
}
