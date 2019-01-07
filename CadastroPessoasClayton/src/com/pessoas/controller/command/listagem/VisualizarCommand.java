package com.pessoas.controller.command.listagem;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.pessoas.controller.InclusaoPessoaController;
import com.pessoas.controller.ListaPessoasController;
import com.pessoas.model.Pessoa;
import com.pessoas.view.InclusaoPessoaView;
import com.pessoas.view.Main;

public class VisualizarCommand extends AbstractCommand {

    public VisualizarCommand(ListaPessoasController receptor) {
        super(receptor);
    }

    @Override
    public void execute() {
        try {
            if (receptor.getPessoa() != null) {

                Pessoa pessoa = receptor.getPessoa();
                InclusaoPessoaController inclusaoPessoaController = new InclusaoPessoaController(receptor.getPessoas(), pessoa);

                Main.removeFrame(InclusaoPessoaView.class.getCanonicalName());

                Main.activePanel(inclusaoPessoaController.getView(), false, false);
            }
        } catch (PropertyVetoException ex) {
            JOptionPane.showConfirmDialog(receptor.getView(), ex.getMessage());
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
