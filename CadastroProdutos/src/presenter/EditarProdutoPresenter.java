/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import collection.ProdutosCollection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import model.ProdutoModel;
import view.EditarProdutoView;

/**
 *
 * @author Harrison
 */
public class EditarProdutoPresenter {

    private EditarProdutoView view;
    private ProdutosCollection produtos;

    public EditarProdutoPresenter(ProdutoModel p) throws IOException {
        view = new EditarProdutoView();
        produtos = new ProdutosCollection();

        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.setVisible(false);
                view.dispose();
            }
        });

        view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    btnSalvar(p);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(view, ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(view, ex.getMessage());
                }
            }
        });
        view.setVisible(true);
    }

    public void btnSalvar(ProdutoModel a) throws Exception {
        ProdutoModel p1 = produtos.getProduto(a.getNome());

        ProdutoModel p2 = p1;

        String nome = view.getTxtNome().getText().toUpperCase();
        String quantidade = view.getTxtQuantidade().getText().toUpperCase();

        if ((nome.equals("")) || (quantidade.equals(""))) {
            throw new Exception("Os campos não podem estar em branco");
        }
        if (!nome.matches("[A-Z a-z Çç]{" + nome.length() + "}")) {
            throw new NumberFormatException("O campo NOME não pode contar número e nem letras com acento");
        } else {
            ProdutoModel p = produtos.getProduto(nome);
            if (p == null) {
                p = new ProdutoModel(nome, Integer.parseInt(quantidade));

                produtos.remove(p1);
                produtos.add(p);

                JOptionPane.showMessageDialog(view, p2.getNome() + " Editado com sucesso.");
            } else if (p != null) {
                if (p1.getNome().equals(nome) && p1.getQuantidade() == Integer.parseInt(quantidade)) {
                    throw new Exception("É necessário modificar os campos para editar");
                }
                if (p1.getNome().equals(nome) && p1.getQuantidade() != Integer.parseInt(quantidade)) {
                    produtos.remove(p1);
                    produtos.add(new ProdutoModel(nome, Integer.parseInt(quantidade)));
                    JOptionPane.showMessageDialog(view, p2.getNome() + " Editado com sucesso.");
                } else {
                    throw new Exception("Já existe um produto cadastrado com este nome: " + "(" + p.getNome() + ").");
                }
            }

        }
    }

    void editar(ProdutoModel p) throws IOException, Exception {
        String nome = p.getNome();
        String quantidade = Integer.toString(p.getQuantidade());

        view.getTxtNome().setText(nome);
        view.getTxtQuantidade().setText(quantidade);
        ProdutoModel p1 = produtos.getProduto(nome);

    }

    public void limparCampos() {
        view.getTxtNome().setText("");
        view.getTxtQuantidade().setText("");
    }

}
