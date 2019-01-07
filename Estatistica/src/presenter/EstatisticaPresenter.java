/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import business.CalculaDesvioPadrao;
import business.CalculaMedia;
import business.CalculaVariancia;
import business.Estatistica;
import collection.DadosEstatisticaCollection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.DadoEstatisticaModel;
import view.EstatisticaView;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Harrison
 */
public class EstatisticaPresenter {

    protected DadosEstatisticaCollection arrayDados;
    private EstatisticaView estatisticaView;
    private ResultadoEstatisticaPresenter resultadoEstatistica;
    private ArrayList<String> dados = new ArrayList<>();
    private String entradaDados;

    public EstatisticaPresenter() {
        estatisticaView = new EstatisticaView();
        try {
            arrayDados = new DadosEstatisticaCollection();
        } catch (IOException ex) {
            Logger.getLogger(EstatisticaPresenter.class.getName()).log(Level.SEVERE, null, ex);
        }
        estatisticaView.getBtnResultados().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnResuldados();
            }
        });
        estatisticaView.getBtnCalcular().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnCalcular();
                } catch (IOException ex) {
                }
            }
        });
        estatisticaView.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnFechar();
            }
        });
        estatisticaView.setVisible(true);
    }

    private void btnCalcular() throws IOException {
        
        if (lerDadosEntrada() == true) {
            Estatistica estatistica = new CalculaMedia();
            double media = estatistica.calcula(dados);
            estatisticaView.getLblMedia().setText(String.valueOf(media));

            estatistica = new CalculaDesvioPadrao();
            double desvioPadrao = estatistica.calcula(dados);
            estatisticaView.getLblDesvioPadrao().setText(String.valueOf(desvioPadrao));

            estatistica = new CalculaVariancia();
            double variancia = estatistica.calcula(dados);
            estatisticaView.getLblVariancia().setText(String.valueOf(variancia));
            
            salvarDados(new DadoEstatisticaModel(entradaDados, media, variancia, desvioPadrao));
          
        }
         else {
            estatisticaView.getTxtEntradaDados().setText("");
            estatisticaView.getLblMedia().setText("MEDIA");
            estatisticaView.getLblVariancia().setText("VARIANCIA");
            estatisticaView.getLblDesvioPadrao().setText("DESVIOPADRAO");
            limparArray();
        }

    }

    private void btnFechar() {
        estatisticaView.dispose();
    }

    private boolean lerDadosEntrada(){
        entradaDados = estatisticaView.getTxtEntradaDados().getText();
        String[] entrada = StringUtils.split(estatisticaView.getTxtEntradaDados().getText(), ";");
        int tam = entrada.length;
        limparArray();
        for (int i = 0; i < tam; i++) {
            entrada[i] = entrada[i].replace(",", ".");
            dados.add(entrada[i]);
        }
        try {
            validaDadosEntrada(dados);
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Digite apenas valores numéricos!");
            return false;
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "O campo deve ser preenchido");
            return false;
        }

    }

    private void validaDadosEntrada(ArrayList<String> dados) throws NumberFormatException, NullPointerException {
        Iterator it = dados.iterator();
        while (it.hasNext()) {
            Object entrada = it.next();
            double a = Double.parseDouble((String) entrada);
        }
        if (dados.size()==0){
            throw new NullPointerException();
        }
    }

    private void limparArray() {
        Iterator it = dados.iterator();
        while (it.hasNext()) {
            Object entrada = it.next();
            it.remove();
        }
    }
    
    private void  btnResuldados(){
        resultadoEstatistica = new ResultadoEstatisticaPresenter();
    }

    private void salvarDados(DadoEstatisticaModel d) throws IOException {
       arrayDados.add(d);
    }

}
