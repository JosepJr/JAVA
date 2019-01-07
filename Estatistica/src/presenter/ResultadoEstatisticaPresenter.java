/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import collection.DadosEstatisticaCollection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DadoEstatisticaModel;
import view.ResultadoEstatisticaView;
/**
 *
 * @author mindkey
 */
public class ResultadoEstatisticaPresenter {

    private ResultadoEstatisticaView view;
    private DefaultTableModel tabela;
    private DadosEstatisticaCollection arrayDados;

    public ResultadoEstatisticaPresenter() {
        try {
            view = new ResultadoEstatisticaView();
            arrayDados = new DadosEstatisticaCollection();
            Object colunas[] = {"Dados Entrada", "Média", "Variância", "Desvio Padrão"};
            tabela = new DefaultTableModel(colunas, 0);
            view.getJtDados().setModel(tabela);
            arrayDados.carregaDados();
            montarTableModel(arrayDados.getArrayList());

            view.getBtnFechar().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnFechar();
                }
            });

            view.setVisible(true);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());

        } catch (IOException e) {
        }

    }

    private void btnFechar() {
        view.dispose();
    }

    private void montarTableModel(Collection<DadoEstatisticaModel> c) {
        tabela.setNumRows(0);
        Iterator<DadoEstatisticaModel> it = c.iterator();
        while (it.hasNext()) {
            DadoEstatisticaModel d = it.next();
            String dados = d.toString();
            String linha[] = dados.split("-");
            tabela.addRow(new Object[]{linha[0], linha[1], linha[2], linha[3]} );
        }
    }
}

