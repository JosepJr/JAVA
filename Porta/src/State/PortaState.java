package State;

import Command.AbrirCommand;
import Command.DestrancarCommand;
import Command.FecharCommand;
import Command.TrancarCommand;
import model.Porta;

public abstract class PortaState {

    Porta porta;

    public PortaState(Porta p) {
        porta = p;
    }

    public void abrir() throws Exception {
        if (this.getClass().getSimpleName().toLowerCase().equals("aberta")
                || this.getClass().getSimpleName().toLowerCase().equals("trancada")) {
            throw new Exception();
        } else {

            new AbrirCommand().executar(porta);
            porta.setState(new Aberta(porta));
        }
    }

    public void fechar() throws Exception {
        if (this.getClass().getSimpleName().toLowerCase().equals("fechada")
                || this.getClass().getSimpleName().toLowerCase().equals("trancada")) {
            throw new Exception();
        } else {
            new FecharCommand().executar(porta);
            porta.setState(new Fechada(porta));
        }

    }

    public void trancar() throws Exception {
        if (this.getClass().getSimpleName().toLowerCase().equals("aberta")
                || this.getClass().getSimpleName().toLowerCase().equals("trancada")) {
            throw new Exception();
        } else {
            new TrancarCommand().executar(porta);
            porta.setState(new Trancada(porta));
        }
    }

    public void destrancar() throws Exception {
        if (this.getClass().getSimpleName().toLowerCase().equals("aberta")
                || this.getClass().getSimpleName().toLowerCase().equals("fechada")) {
            throw new Exception();
        } else {
            new DestrancarCommand().executar(porta);
            porta.setState(new Fechada(porta));
        }
    }

    public PortaState getState() {
        return this;
    }
}
