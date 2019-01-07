/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacaixaeletronico;

import java.util.ArrayList;

/**
 *
 * @author Josep
 */
public class CaixaEletronico {

    private final ArrayList<Cedula> notas;
    private final ArrayList<Cedula> moedas;

    public CaixaEletronico() {
        notas = new ArrayList<>();
        moedas = new ArrayList<>();
        notas.add(new Nota(100, 1));
        notas.add(new Nota(50, 1));
        notas.add(new Nota(20, 1));
        notas.add(new Nota(10, 1));
        notas.add(new Nota(5, 1));
        notas.add(new Nota(2, 1));
        notas.add(new Nota(1, 1));
        moedas.add(new Moeda(50, 1));
        moedas.add(new Moeda(25, 1));
        moedas.add(new Moeda(10, 1));
        moedas.add(new Moeda(5, 1));
        moedas.add(new Moeda(1, 1));
    }

    private double valorTotalNotas() {
        double soma = 0;
        for (Cedula c : notas) {
            soma = soma + (c.getValor() * c.getQuantidade());
        }
        return soma;
    }

    private double valorTotalMoedas() {
        double soma = 0;
        for (Cedula m : moedas) {
            soma = soma + (m.getValor() * m.getQuantidade());
        }
        return soma;
    }

    private void sacarNota(double valorsaque) {
        if(valorsaque != 0){
            for (Cedula n : notas) {
                int index = 0;
                while ((valorsaque > 0) && (valorsaque / n.getValor() > 1) && (n.getQuantidade() > 0)) {
                    valorsaque = valorsaque - n.getValor();
                    n.subtrair();
                    index++;
                }
                System.out.println(index + "  Nota(s) de " + n.getValor() + " Real(is)...");
            }
        }
        else{
            System.out.print("0 Notas e ");
        }

    }

    private void sacarMoeda(double valorsaque) {
        if(valorsaque != 0){  
            for (Cedula m : moedas) {
                int index = 0;
                while ((valorsaque != 0) && (valorsaque / m.getValor() > 1) && (m.getQuantidade() > 0)) {
                    valorsaque = valorsaque - m.getValor();
                    m.subtrair();
                    index++;
                }
                System.out.println(index + "  Moeda(s) de " + m.getValor() / 100 + " Centavo(s)...");
            }
        }
        else{
            System.out.print("0 centavos...");
        }
    }

public void sacar(double valor) {
        double nota = (int) valor;
        double moeda = (int) ((valor - nota)*100);
        System.out.println(nota+"."+moeda);
        if(nota == 0 && moeda == 0){
            System.out.println("Não foi feito nenhum saque pois o valor não é válido..."); 
        }
        else{
            if(moeda > valorTotalMoedas()){
                System.out.println("O caixa não possuí moedas suficientes...");
            }
            else{
                if(nota > valorTotalNotas() ){
                    System.out.println("O Caixa não possuí notas suficientes...");
                }
                else{
                    System.out.println("O valor do saque é de: "+ nota + "Reais e"+ moeda/100 + "Centavos");
                    sacarNota(nota);
                    sacarMoeda(moeda);
                }            
            }
        }
    }

    public boolean alimentarCaixa(double valor, int quantidade) {
        return true;
    }

}
