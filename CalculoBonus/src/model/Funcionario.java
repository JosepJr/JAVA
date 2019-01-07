package model;

import java.text.DecimalFormat;
import business.BonusTratador;
import business.ProcessadorBonus;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public abstract class Funcionario {

    private String nome;
    private int idade;
    private double salarioBase;
    private double salarioTotal;
    private int faltas;
    private ProcessadorBonus processador ;
    private ArrayList<String> bonusRecebidos;

    public Funcionario(String nome, int idade, double salarioBase, int faltas) {
        this.nome = nome;
        this.idade = idade;
        this.salarioBase = salarioBase;
        this.faltas = faltas;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double getSalarioTotal() {
        return salarioTotal;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;

    }
    
    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public void setSalarioTotal(double salarioTotal) {
        this.salarioTotal = salarioTotal;
    }
    
    
    @Override
    public String toString() {
        DecimalFormat formatador = new DecimalFormat("0.000");
        return "Nome:" + this.nome + ", idade:" + this.idade
                + ", salario base:" + this.salarioBase + ", salario total:" + formatador.format(this.salarioTotal);
    }

    public void add(String nomeBonus) {
        bonusRecebidos.add(nomeBonus);
    }

    public ArrayList<String> getBonusRecebidos() {
        return bonusRecebidos;
    }
    
    public void processar(Funcionario f){
        processador.processar(this);      
    }

}
