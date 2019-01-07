package pessoas.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pessoas.model.Pessoa;
import pessoas.collection.Pessoas;
import pessoas.view.IncluirPessoaView;

public class IncluirPessoaPresenter {

    protected Pessoas pessoas;
    private IncluirPessoaView view;

    public IncluirPessoaPresenter() {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    pessoas = new Pessoas();
                    view = new IncluirPessoaView();
                    view.setVisible(true);
                    view.getBtnSalvar().addActionListener(new java.awt.event.ActionListener() {

                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            btnSalvarPessoa(evt);
                        }
                    });
                    view.getBtnFechar().addActionListener(new java.awt.event.ActionListener() {

                        @Override
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            view.setVisible(false);
                            view.dispose();
                        }
                    });
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(view, ex.getMessage());
                }
            }
        });
    }

    public void btnSalvarPessoa(ActionEvent evt) {
        String nome = view.getTxtNome().getText();
        String telefone = view.getTxtTelefone().getText();

        try {

            if ((!nome.equals("")) && (!telefone.equals(""))) {
                Pessoa p = new Pessoa(nome, telefone);
                if (!pessoas.add(p)) {
                    throw new Exception("Pessoa já existente");
                } else {
                    JOptionPane.showMessageDialog(view, nome + " cadastrado com sucesso!");
                    view.getTxtNome().setText("");
                    view.getTxtTelefone().setText("");
                }
            } else {
                throw new Exception("Você precisa informar os campos");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, e.getMessage());
        }
    }

}
