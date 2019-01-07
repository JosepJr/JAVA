package com.pessoas.controller.command.listagem;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.pessoas.controller.ListaPessoasController;

public class ExcluirCommand extends AbstractCommand {

    public ExcluirCommand(ListaPessoasController receptor) {
        super(receptor);
    }

    @Override
    public void execute() {

        try {
            if (receptor.getPessoa() != null) {
                if (JOptionPane.showConfirmDialog(receptor.getView(), "Deseja realmente excluir o registro?",
                        receptor.getPessoa().getNome(), JOptionPane.YES_NO_OPTION) == 0) {
                    receptor.getPessoas().remove(receptor.getPessoa().getNome());
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(receptor.getView(), ex.getMessage());
            Logger.getLogger(ListaPessoasController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
