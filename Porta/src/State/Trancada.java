/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import Command.DestrancarCommand;
import model.Porta;

/**
 *
 * @author Aluno
 */
public class Trancada extends PortaState {

    public Trancada(Porta p) {
        super(p);
    }

    @Override
    public void destrancar(){
        new DestrancarCommand().executar(porta);
        porta.setState(new Fechada(porta));
    }
    
}
