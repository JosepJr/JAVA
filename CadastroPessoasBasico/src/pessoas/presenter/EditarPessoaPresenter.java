/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pessoas.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pessoas.collection.Pessoas;
import pessoas.model.Pessoa;
import pessoas.view.IncluirPessoaView;

/**
 *
 * @author Harrison
 */
public class EditarPessoaPresenter {
    IncluirPessoaView view;
    Pessoas pessoas;
    EditarPessoaPresenter(Pessoa p) {
        view = new IncluirPessoaView();
        view.setVisible(true);
        view.getTxtNome().setText(p.getNome());
        view.getTxtTelefone().setText(p.getTelefone());
        view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnSalvarPessoa(e);
                } catch (IOException ex) {
                    Logger.getLogger(IncluirPessoaPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                view.dispose();
            }
        });

    }

    public void btnSalvarPessoa(ActionEvent e) throws IOException {
        String nome = view.getTxtNome().getText();
        String telefone = view.getTxtTelefone().getText();
        Pessoa p = new Pessoa(nome, telefone);

        try {
            pessoas.add(p);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(view, "Não foi possível savar os dados editados.");
        } catch (NullPointerException a) {
            JOptionPane.showMessageDialog(view, "Não foi possível savar os dados editados.");
        }
    }
}
