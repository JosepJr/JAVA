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
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ProdutoModel;
import view.ListarProdutosView;

/**
 *
 * @author Harrison
 */
public class ListarProdutosPresenter {

    private ListarProdutosView produtosView;
    private DefaultTableModel table;
    private ProdutosCollection produtos;

    public ListarProdutosPresenter() throws FileNotFoundException, IOException {
        produtosView = new ListarProdutosView();
        produtos = new ProdutosCollection();
        Object colunas[] = {"Nome", "Quantidade"};
        table = new DefaultTableModel(colunas, 0);
        produtosView.getTblProdutos().setModel(table);
        montarTableModel(produtos.getArrayList());

        produtosView.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                produtosView.setVisible(false);
                produtosView.dispose();
            }
        });

        produtosView.getBtnExluir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    btnExcluir();
                } catch (IOException ex) {
                    Logger.getLogger(ListarProdutosPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        produtosView.getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    btnEditar();
                } catch (IOException ex) {
                    Logger.getLogger(ListarProdutosPresenter.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(ListarProdutosPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        produtosView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    btnBuscar();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(produtosView, ex.getMessage());
                } 
            }
        });

        produtosView.setVisible(true);
    }

    private void montarTableModel(Collection<ProdutoModel> c) {
        table.setNumRows(0);
        Iterator<ProdutoModel> it = c.iterator();
        while (it.hasNext()) {
            ProdutoModel p = it.next();
            String produto = p.toString();
            String linha[] = produto.split(" - ");
            table.addRow(new Object[]{linha[0], linha[1]});
        }
    }

    public void btnExcluir() throws IOException {
        try {
            int linha = produtosView.getTblProdutos().getSelectedRow();

            String nome = (String) produtosView.getTblProdutos().getValueAt(linha, 0);
            int quantidade = Integer.parseInt((String) produtosView.getTblProdutos().getValueAt(linha, 1));
            ProdutoModel p = new ProdutoModel(nome, quantidade);
            new ExcluirProdutoPresenter(p).excluir(p);
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(produtosView, "Selecione um produto para excluir.");
        }

    }

    public void btnEditar() throws IOException, Exception {
        try {

            int linha = produtosView.getTblProdutos().getSelectedRow();
            String nome = (String) produtosView.getTblProdutos().getValueAt(linha, 0);
            ProdutoModel p = produtos.getProduto(nome);
            new EditarProdutoPresenter(p).editar(p);

        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(produtosView, "Selecione um produto para editar.");
        }

    }

    public void btnBuscar() throws Exception {
        String busca = produtosView.getTxtBusca().getText().toUpperCase();
        if ((busca.equals(""))) {
            throw new Exception("O campo de busca não pode estar em branco.");
        } else if (!busca.matches("[A-Z a-z Çç]{" + busca.length() + "}")) {
            produtosView.getTxtBusca().setText("");
            throw new NumberFormatException("O campo de BUSCA só pode conter letras.");
        } else {
            ProdutoModel p = produtos.getProduto(busca);
            if (p == null) {
                produtosView.getTxtBusca().setText("");
                throw new Exception("Este produto não foi encontrado no sistema");
            } else {
                new EditarProdutoPresenter(p).editar(p);
            }
        }
        
    }
}
