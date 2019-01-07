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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import model.ProdutoModel;

/**
 *
 * @author Harrison
 */
public class ProdutosCollection {

    ArrayList<ProdutoModel> produtos = null;
    private File arquivo;

    public ProdutosCollection() throws FileNotFoundException, IOException {
        if (produtos == null) {
            produtos = new ArrayList<>();
        }
        arquivo = new File("src/data/estoque.txt");
        carregaDados();
        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }
    }

    public void carregaDados() throws FileNotFoundException {
        Scanner scan = new Scanner(arquivo);
        while (scan.hasNextLine()) {
            String linha = scan.nextLine();
            Scanner scanline = new Scanner(linha);
            scanline.useDelimiter(" - ");
            while (scanline.hasNext()) {
                String nome = scanline.next();
                int quantidade = Integer.parseInt(scanline.next());
                produtos.add(new ProdutoModel(nome, quantidade));
            }

        }

    }

    public void remove(ProdutoModel p) throws IOException {
        this.produtos.remove(p);
        FileWriter w = new FileWriter(arquivo);
        BufferedWriter bf = new BufferedWriter(w);
        for (ProdutoModel pessoa : this.produtos) {
            bf.write(pessoa.toString());
            bf.newLine();
        }
        bf.close();
    }

    public boolean add(ProdutoModel p) throws IOException {
        boolean add = this.produtos.add(p);
        FileWriter w = new FileWriter(arquivo, true);
        BufferedWriter bf = new BufferedWriter(w);
        bf.write(p.toString());
        bf.newLine();
        bf.close();

        return add;
    }

    public ArrayList<ProdutoModel> getArrayList() {
        return produtos;
    }

    public ProdutoModel getProduto(String nome) {
        for (ProdutoModel p : this.produtos) {
            if (p.getNome().equals(nome)) {
                return p;
            }
        }
        return null;
    }

}
