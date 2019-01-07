/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pessoas.presenter;

import pessoas.presenter.apoio.ComparadorDeTelefonePessoa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pessoas.model.Pessoa;
import pessoas.collection.Pessoas;
import pessoas.view.ListaPessoasView;

/**
 *
 * @author clayton
 */
public final class ListaPessoasPresenter {

    private DefaultTableModel tableModel;
    private Pessoas pessoas;
    private ListaPessoasView view;

    public ListaPessoasPresenter() {
        try {
            view = new ListaPessoasView();
            Object colunas[] = {"Nome", "Telefone"};
            tableModel = new DefaultTableModel(colunas, 0);
            pessoas = new Pessoas();
            pessoas.carregaPessoas();
            montarTableModel(pessoas.getTreeSet());

            view.getCbOrdenarTelefone().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (view.getCbOrdenarTelefone().isSelected()) {
                        ArrayList<Pessoa> lista = new ArrayList<Pessoa>(pessoas.getTreeSet());
                        Collections.sort(lista, new ComparadorDeTelefonePessoa());
                        montarTableModel(lista);
                    } else {
                        montarTableModel(pessoas.getTreeSet());
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

            view.getJtPessoas().setModel(tableModel);
            view.setVisible(true);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
        }
        
        view.getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnEditar();
            }
        });

    }

    private void montarTableModel(Collection<Pessoa> c) {
        tableModel.setNumRows(0);
        Iterator<Pessoa> it = c.iterator();
        while (it.hasNext()) {
            Pessoa p = it.next();
            String pessoa = p.toString();
            String linha[] = pessoa.split(",");
            tableModel.addRow(new Object[]{linha[0], linha[1]});
        }
    }
    
    public void btnEditar(){
  
        try{
        int linha = view.getJtPessoas().getSelectedRow();
        
        String nome = (String) view.getJtPessoas().getValueAt(linha, 0);
        String telefone = (String) view.getJtPessoas().getValueAt(linha, 1);
        Pessoa p = new Pessoa(nome, telefone);
        new EditarPessoaPresenter(p);
        }catch (ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(view, "Selecione uma pessoa para editar.");
        }
    }
}
