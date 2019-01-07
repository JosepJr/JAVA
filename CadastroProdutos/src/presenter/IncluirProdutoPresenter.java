/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import collection.ProdutosCollection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import model.ProdutoModel;
import view.IncluirProdutoView;

/**
 *
 * @author Harrison
 */
public class IncluirProdutoPresenter {

    private ProdutosCollection produtos;
    private IncluirProdutoView view;

    public IncluirProdutoPresenter() throws FileNotFoundException, IOException {
        view = new IncluirProdutoView();
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
                    btnSalvar();
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(view,e.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(view, ex.getMessage());
                }
            }
        });
        view.setVisible(true);
    }

    public void btnSalvar() throws NumberFormatException, Exception {
        String nome = view.getTxtNome().getText().toUpperCase();
        String quantidade = view.getTxtQuantidade().getText().toUpperCase();

        if ((nome.equals("")) || (quantidade.equals(""))) {
            throw new Exception("Os campos não podem estar em branco.");
        } else if (!nome.matches("[A-Z a-z Çç]{"+nome.length()+"}")){
            limparCampos();
            throw new NumberFormatException("O campo NOME só pode conter letras.");
        } else {
            ProdutoModel p = produtos.getProduto(nome);
            if (p != null) {
                produtos.remove(p);
                int qtde = p.getQuantidade();
                qtde += Integer.parseInt(quantidade);
                p.setQuantidade(qtde);
                produtos.add(p);
                limparCampos();
                JOptionPane.showMessageDialog(view, "O produto ("+ p.getNome()+ ") foi adicionado com sucesso.");
            }else{
                produtos.add(new ProdutoModel(nome, Integer.parseInt(quantidade)));
                JOptionPane.showMessageDialog(view, "O produto ("+ nome+ ") foi adicionado com sucesso.");
                limparCampos();
            }
        }
    }



    public void limparCampos() {
        view.getTxtNome().setText("");
        view.getTxtQuantidade().setText("");
    }
}
