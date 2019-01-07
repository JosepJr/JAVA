package Command;

import model.Porta;

public class FecharCommand implements PortaCommand {
    
    @Override
    public void executar(Porta p) {
        System.out.println("Porta sendo fechada...");
        System.out.println("Porta fechada.");
    }

   
    
}
