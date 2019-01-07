package com.pessoas.controller.command.inclusao;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.pessoas.controller.InclusaoPessoaController;
import com.pessoas.controller.estados.inclusao.EstadoVisualizacao;
import com.pessoas.model.Pessoa;

public class AlterarCommand extends AbstractCommand {

    public AlterarCommand(InclusaoPessoaController receptor) {
        super(receptor);
    }

    @Override
    public void execute() {
        try {
            valida();
            receptor.setEstado(new EstadoVisualizacao(receptor));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(receptor.getView(), ex.getMessage());
            Logger.getLogger(AlterarCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected boolean salva(Pessoa pessoa) throws IOException {
        return !receptor.getPessoas().altera(pessoa, receptor.getNomeAnterior());
    }
}
