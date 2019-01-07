/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import model.DadoEstatisticaModel;

/**
 *
 * @author mindkey
 */
public class DadosEstatisticaCollection {

    ArrayList<DadoEstatisticaModel> dadosCalculo = null;
    private final File arquivo;

    public DadosEstatisticaCollection() throws IOException {
        if (dadosCalculo == null) {
            dadosCalculo = new ArrayList<>();
        }
        arquivo = new File("src/data/resultadosEstatistica.txt");
        carregaDados();
    }

    public void carregaDados() throws FileNotFoundException {
        Scanner scan = new Scanner(arquivo);
        while (scan.hasNextLine()) {
            String linha = scan.nextLine();
            Scanner scanline = new Scanner(linha);
            scanline.useDelimiter(" - ");
            while (scanline.hasNext()) {
                String entrada = scanline.next();
                double media = Double.parseDouble(scanline.next());
                double variancia = Double.parseDouble(scanline.next());
                double desvioPadrao = Double.parseDouble(scanline.next());
                dadosCalculo.add(new DadoEstatisticaModel(entrada, media, variancia, desvioPadrao));
            }
        }
    }

    public boolean add(DadoEstatisticaModel p) throws IOException {
        boolean add = this.dadosCalculo.add(p);
        FileWriter w = new FileWriter(arquivo, true);
        BufferedWriter bf = new BufferedWriter(w);
        bf.write(p.toString());
        bf.newLine();
        bf.close();

        return add;
    }
    
    public ArrayList<DadoEstatisticaModel> getArrayList() {
        return dadosCalculo;
    }
    
     public Iterator<DadoEstatisticaModel> iterator() {
        return this.dadosCalculo.iterator();
    }
}
