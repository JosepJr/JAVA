/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import view.OrdenaDadosView;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Harrison
 */
public class OrdenaDadosListener {

    OrdenaDadosView view;
    ArrayList <String> dados;
    

    public OrdenaDadosListener() {
        this.dados = new ArrayList();
        this.view = new OrdenaDadosView();
       
        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnFechar();
            }
        });
        view.getBtnOrdenar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnOrdenar();
            }
        });
        view.getCboxEscolhaOrdenacao().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               cboxTipoOrdenacao();
            }
        });
        view.setVisible(true);
    }

    public void btnFechar() {
        view.setVisible(false);
        view.dispose();
    }

    public void btnOrdenar() {
       if(lerDadosEntrada() == true){
           
       }
    }

    public boolean lerDadosEntrada() {
        String[] entrada = StringUtils.split(view.getTxtEntradaDados().getText(),";");
        for (int i = 0; i < entrada.length; i++) {
            entrada[i] = entrada[i].replace(",", ".");
            dados.add(entrada[i]);
        }
        try{
            validaDados(dados);
            return true;
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Digite apenas valores numéricos!");
            return false;
        }
        
    }
    
    public void validaDados(ArrayList <String> dados) throws NumberFormatException{
        Iterator it = dados.iterator();
        while (it.hasNext()){
            Object entrada = it.next();
            double a = Double.parseDouble((String) entrada);
        }
    }
    
    public void cboxTipoOrdenacao(){
        
    }
}
