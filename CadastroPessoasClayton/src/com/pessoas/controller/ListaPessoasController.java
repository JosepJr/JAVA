package com.pessoas.controller;

import com.pessoas.collection.IPessoaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import com.pessoas.model.Pessoa;
import com.pessoas.collection.observer.Observer;
import com.pessoas.controller.estados.listagem.EstadoListaPessoas;
import com.pessoas.controller.estados.listagem.EstadoNaoSelecionado;
import com.pessoas.controller.estados.listagem.EstadoSelecionado;
import com.pessoas.view.ListaPessoasView;

public final class ListaPessoasController implements Observer {

    private ListaPessoasView view;
    private EstadoListaPessoas estado;
    private IPessoaDAO pessoas;
    private Pessoa pessoa;
    private DefaultTableModel tm;

    public ListaPessoasController(IPessoaDAO pessoas) throws FileNotFoundException, IOException {
        view = new ListaPessoasView();
        tm = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Nome", "Telefone"}) {

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        view.getTabela().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        view.getTabela().addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent e) {
                setEstado(new EstadoSelecionado(ListaPessoasController.this));
            }
        });

        this.pessoas = pessoas;
        setPessoas(this.pessoas);

        view.getCbOrdena().addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordenaPessoas(evt);
            }
        });

        view.getBtnExcluir().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                exclui();
            }
        });

        view.getBtnVisualizar().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                visualizar();
            }
        });

        setEstado(new EstadoNaoSelecionado(this));

        view.setVisible(true);
    }

    public void exclui() {
        estado.exclui();
    }

    public void visualizar() {
        estado.visualiza();
    }

    public void setEstado(EstadoListaPessoas estado) {
        this.estado = estado;
    }

    public void setPessoas(IPessoaDAO pessoas) throws FileNotFoundException, IOException {
        this.pessoas = pessoas;
        tm.setNumRows(0);
        this.pessoas.carregaPessoas();
        carregaTableModel(this.pessoas.getTreeSet());
        this.view.getTabela().setModel(tm);
    }

    private void ordenaPessoas(ActionEvent evt) {
        if (view.getCbOrdena().isSelected()) {
            ArrayList<Pessoa> lista = new ArrayList<Pessoa>(pessoas.getTreeSet());
            Collections.sort(lista, new ComparadorDeTelefonePessoa());
            carregaTableModel(lista);
        } else {
            carregaTableModel(pessoas.getTreeSet());
        }
    }

    public void carregaTableModel(Collection<Pessoa> c) {
        tm.setNumRows(0);
        Iterator<Pessoa> it = c.iterator();
        while (it.hasNext()) {
            Pessoa p = it.next();
            String linha = p.toString();
            String campos[] = linha.split(",");
            tm.addRow(new Object[]{campos[0], campos[1]});
        }
    }

    public ListaPessoasView getView() {
        return view;
    }

    @Override
    public void update(TreeSet<Pessoa> pessoas) {
        carregaTableModel(pessoas);
        estado.deseleciona();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public IPessoaDAO getPessoas() {
        return pessoas;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
