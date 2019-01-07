/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package State;

import Command.AbrirCommand;
import Command.TrancarCommand;
import model.Porta;

/**
 *
 * @author Aluno
 */
public class Fechada extends PortaState {

    public Fechada(Porta p) {
        super(p);
    }

    @Override
    public void trancar() {
        new TrancarCommand().executar(porta);
        porta.setState(new Trancada(porta));
    }

    @Override
    public void abrir() {
        new AbrirCommand().executar(porta);
        porta.setState(new Aberta(porta));
    }
    

}
