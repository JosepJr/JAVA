package com.pessoas.controller.estados.inclusao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.pessoas.controller.InclusaoPessoaController;

public class EstadoVisualizacao extends EstadoPessoaView {

    public EstadoVisualizacao(InclusaoPessoaController objeto) {
        super(objeto);
        objeto.getView().setTitle("Visualização");

        objeto.setNomeAnterior(objeto.getPessoa().getNome());

        objeto.getView().getTxtNome().setText(objeto.getPessoa().getNome());
        objeto.getView().getTxtNome().setEditable(false);
        objeto.getView().getTxtTelefone().setText(objeto.getPessoa().getTelefone());
        objeto.getView().getTxtTelefone().setEditable(false);
        objeto.getView().getBtnSalvar().setText("Editar");
        objeto.getView().getBtnSalvar().requestFocus();
        objeto.getView().getBtnSalvar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                editar();
            }
        });
    }

    @Override
    public void editar() {
        objeto.setEstado(new EstadoAlteracao(objeto));
    }
}
