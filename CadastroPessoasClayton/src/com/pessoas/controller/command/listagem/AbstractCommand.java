package com.pessoas.controller.command.listagem;

import com.pessoas.controller.command.Command;
import com.pessoas.controller.ListaPessoasController;

public abstract class AbstractCommand implements Command {

    protected ListaPessoasController receptor;

    @Override
    public abstract void execute();

    public AbstractCommand(ListaPessoasController receptor) {
        this.receptor = receptor;
    }
}
