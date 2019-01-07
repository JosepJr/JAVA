package State;

import Command.FecharCommand;
import model.Porta;

public class Aberta extends PortaState {

    public Aberta(Porta p) {
        super(p);
    }

    @Override
    public void fechar() {
        new FecharCommand().executar(porta);
        porta.setState(new Fechada(porta));
    }
    
}
