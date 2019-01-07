package com.pessoas.controller.estados.listagem;

import com.pessoas.controller.ListaPessoasController;
import com.pessoas.controller.command.listagem.ExcluirCommand;
import com.pessoas.controller.command.listagem.VisualizarCommand;

public class EstadoSelecionado extends EstadoListaPessoas {

    public EstadoSelecionado(ListaPessoasController objeto) {
        super(objeto);
        objeto.setPessoa(null);
        int linha = objeto.getView().getTabela().getSelectedRow();
        String nome = (String) objeto.getView().getTabela().getValueAt(linha, 0);
        objeto.setPessoa(objeto.getPessoas().getPessoaByName(nome));
        objeto.getView().getBtnExcluir().setEnabled(true);
        objeto.getView().getBtnVisualizar().setEnabled(true);
    }

    @Override
    public void deseleciona() {
        objeto.setEstado(new EstadoNaoSelecionado(objeto));
    }

    @Override
    public void exclui() {
        new ExcluirCommand(objeto).execute();
    }

    @Override
    public void visualiza() {
        new VisualizarCommand(objeto).execute();
    }
}
