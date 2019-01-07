package com.pessoas.controller.estados.listagem;

import com.pessoas.controller.ListaPessoasController;

public class EstadoNaoSelecionado extends EstadoListaPessoas {

    public EstadoNaoSelecionado(ListaPessoasController objeto) {
        super(objeto);
        objeto.setPessoa(null);
        objeto.getView().getBtnExcluir().setEnabled(false);
        objeto.getView().getBtnVisualizar().setEnabled(false);
    }

    @Override
    public void seleciona() {
        objeto.setEstado(new EstadoSelecionado(objeto));
    }
}
