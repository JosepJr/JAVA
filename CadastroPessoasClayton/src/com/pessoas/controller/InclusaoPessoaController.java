package com.pessoas.controller;

import com.pessoas.collection.IPessoaDAO;
import com.pessoas.model.Pessoa;
import com.pessoas.controller.estados.inclusao.EstadoInclusao;
import com.pessoas.controller.estados.inclusao.EstadoPessoaView;
import com.pessoas.controller.estados.inclusao.EstadoVisualizacao;
import com.pessoas.view.InclusaoPessoaView;

public final class InclusaoPessoaController {

    private IPessoaDAO pessoas;
    private InclusaoPessoaView view;
    private Pessoa pessoa;
    private String nomeAnterior;
    private EstadoPessoaView estado;

    public InclusaoPessoaController(IPessoaDAO pessoas, Pessoa pessoa) {

        this.pessoas = pessoas;

        view = new InclusaoPessoaView();
        view.setVisible(true);

        setPessoa(pessoa);

        if (pessoa == null) {
            setEstado(new EstadoInclusao(this));
        } else {
            setEstado(new EstadoVisualizacao(this));
        }
    }

    public void salvar() {
        estado.salvar();
    }

    public void setPessoas(IPessoaDAO pessoas) {
        this.pessoas = pessoas;
    }

    public InclusaoPessoaView getView() {
        return view;
    }

    public void limpaCampos() {
        view.getTxtNome().setText("");
        view.getTxtTelefone().setText("");
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public IPessoaDAO getPessoas() {
        return pessoas;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void setEstado(EstadoPessoaView estado) {
        this.estado = estado;
    }

    public void setNomeAnterior(String nomeAnterior) {
        this.nomeAnterior = nomeAnterior;
    }

    public String getNomeAnterior() {
        return nomeAnterior;
    }
}
