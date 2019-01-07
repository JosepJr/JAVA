package com.pessoas.controller.command.inclusao;

import java.io.IOException;
import javax.swing.JOptionPane;
import com.pessoas.controller.command.Command;
import com.pessoas.controller.InclusaoPessoaController;
import com.pessoas.model.Pessoa;

public abstract class AbstractCommand implements Command {

    protected InclusaoPessoaController receptor;

    public AbstractCommand(InclusaoPessoaController receptor) {
        this.receptor = receptor;
    }

    @Override
    public abstract void execute();

    protected void valida() throws IOException, Exception {
        String nome = receptor.getView().getTxtNome().getText();
        String telefone = receptor.getView().getTxtTelefone().getText();

        if ((!nome.equals("")) && (!telefone.equals(""))) {
            Pessoa pessoa = new Pessoa(nome, telefone);
            if (!pessoa.getNome().contains(",")) {
                if (salva(pessoa)) {
                    JOptionPane.showMessageDialog(receptor.getView(), "Pessoa já existente");
                } else {
                    receptor.setPessoa(pessoa);
                    JOptionPane.showMessageDialog(receptor.getView(), nome + " cadastrado com sucesso!");
                    receptor.limpaCampos();
                    receptor.getView().getTxtNome().requestFocus();
                }
            } else {
                throw new Exception("Nome não pode conter vírgula!");
            }
        } else {
            throw new Exception("Você precisa informar os campos");
        }
    }

    protected abstract boolean salva(Pessoa pessoa) throws IOException;
}
