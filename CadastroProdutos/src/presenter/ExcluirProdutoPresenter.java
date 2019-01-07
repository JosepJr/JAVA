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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ProdutoModel;
import view.ExcluirProdutoView;

/**
 *
 * @author Harrison
 */
public class ExcluirProdutoPresenter {

    private ExcluirProdutoView view;
    private ProdutosCollection produtos;

    public ExcluirProdutoPresenter(ProdutoModel p) throws IOException {
        view = new ExcluirProdutoView();
        produtos = new ProdutosCollection();
        
        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.setVisible(false);
                view.dispose();
            }
        });
        
        view.getBtnExcluir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    btnExcluir(p);
                } catch (IOException ex) {
                    Logger.getLogger(ExcluirProdutoPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        view.setVisible(true);
    }
    public void btnExcluir(ProdutoModel p) throws IOException{
        ProdutoModel p1 = produtos.getProduto(p.getNome());
        String nome = p1.getNome();
        produtos.remove(p1);
        JOptionPane.showMessageDialog(view, nome +" excluído com sucesso");
    }

    void excluir(ProdutoModel p) {
        String nome= p.getNome();
        String quantidade = Integer.toString(p.getQuantidade());
        
        view.getTxtNome().setText(nome);
        view.getTxtQuantidade().setText(quantidade);
        view.getTxtNome().setEnabled(false);
        view.getTxtQuantidade().setEnabled(false);
    }
}
