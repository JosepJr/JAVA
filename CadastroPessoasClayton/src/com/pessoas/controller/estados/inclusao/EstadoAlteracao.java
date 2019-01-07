package com.pessoas.controller.estados.inclusao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.pessoas.controller.InclusaoPessoaController;
import com.pessoas.controller.command.inclusao.AlterarCommand;

public class EstadoAlteracao extends EstadoPessoaView {

    public EstadoAlteracao(InclusaoPessoaController objeto) {
        super(objeto);

        objeto.getView().getTxtNome().setEditable(true);
        objeto.getView().getTxtTelefone().setEditable(true);

        objeto.getView().getBtnSalvar().setText("Salvar");

        objeto.getView().getBtnFechar().setText("Cancelar");
        objeto.getView().getBtnFechar().removeActionListener(objeto.getView().getBtnFechar().getActionListeners()[0]);
        objeto.getView().getBtnFechar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });

        objeto.getView().getTxtNome().requestFocus();
    }

    @Override
    public void salvar() {
        new AlterarCommand(objeto).execute();
    }

    @Override
    public void cancelar() {
        objeto.setEstado(new EstadoVisualizacao(objeto));
    }
}
