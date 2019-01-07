package com.pessoas.controller.estados.inclusao;

import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import com.pessoas.controller.InclusaoPessoaController;

public abstract class EstadoPessoaView {

    protected InclusaoPessoaController objeto;

    public EstadoPessoaView(InclusaoPessoaController objeto) {
        this.objeto = objeto;
        limpaListeners();

        objeto.getView().getBtnSalvar().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvar();
            }
        });
        objeto.getView().getBtnFechar().setText("Fechar");
        objeto.getView().getBtnFechar().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechar();
            }
        });

    }

    public void salvar() {
    }

    public void editar() {
    }

    public void cancelar() {
    }

    public final void fechar() {
        objeto.getView().setVisible(false);
        objeto.getView().dispose();
    }

    protected void limpaListeners() {

        for (Component c : objeto.getView().getContentPane().getComponents()) {
            if (c instanceof JButton) {
                for (ActionListener al : ((JButton) c).getActionListeners()) {
                    ((JButton) c).removeActionListener(al);
                }
            }
        }
    }
}
