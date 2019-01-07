package com.pessoas.controller.estados.inclusao;

import com.pessoas.controller.InclusaoPessoaController;
import com.pessoas.controller.command.inclusao.IncluirCommand;

public class EstadoInclusao extends EstadoPessoaView {

    public EstadoInclusao(InclusaoPessoaController objeto) {
        super(objeto);
        objeto.getView().getTxtNome().setText("");
        objeto.getView().getTxtTelefone().setText("");
        objeto.getView().getTxtNome().requestFocus();
    }

    @Override
    public void salvar() {
        new IncluirCommand(objeto).execute();
    }
}
