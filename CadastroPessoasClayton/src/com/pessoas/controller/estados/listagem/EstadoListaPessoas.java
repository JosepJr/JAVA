package com.pessoas.controller.estados.listagem;

import com.pessoas.controller.ListaPessoasController;

public abstract class EstadoListaPessoas {

    protected ListaPessoasController objeto;

    public EstadoListaPessoas(ListaPessoasController objeto) {
        objeto.getView().getLblTotal().setText(Integer.toString(objeto.getPessoas().getTreeSet().size()));
        this.objeto = objeto;
    }

    public void exclui() {
    }

    public void visualiza() {
    }

    public void seleciona() {
    }

    ;

    public void deseleciona() {
    }
;
}
