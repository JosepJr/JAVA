/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uec;

/**
 *
 * @author Josep
 */
public class Lutador {
    
    private String nome;
    private String nacionalidade;
    private int idade;
    private float altura;
    private float peso;
    private String categoria;
    private int vitorias;
    private int derrotas;
    private int empates;

    public Lutador(String nome, String nacionalidade, int idade, float altura, float peso, int vitorias, int derrotas, int empates) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.idade = idade;
        this.altura = altura;
        this.setPeso(peso);
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.empates = empates;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
        this.setCategoria(peso);
    }

    public String getCategoria() {
        return categoria;
    }

    private void setCategoria(float peso) {
        if ((peso <= 52)||(peso >= 120)){
            this.categoria = "invalido";
        }
        if((peso > 52) && (peso <= 72)){
            this.categoria = "leve";
        }
        if((peso > 72)&& (peso <= 84)){
            this.categoria = "medio";
        }
        if((peso > 84)&& (peso <= 120)){
            this.categoria = "pesado";
        }               
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }
       
    public void apresentar(){
        System.out.printf("Lutador: %s \n", getNome());
        System.out.printf(" Nacionalidade: %s \n", getNacionalidade());
        System.out.printf(" Idade: %d anos \n", getIdade());
        System.out.printf(" Altura: %.2f Metros\n", getAltura());
        System.out.printf(" Peso: %.2f Kgs \n", getPeso());
        System.out.printf(" Categoria: %s \n", getCategoria());
        System.out.printf(" Vitorias: %d \n", getVitorias());
        System.out.printf(" Derrotas: %d \n", getDerrotas());
        System.out.printf(" Empates: %d\n", getEmpates());   
    }
    
     public void ganharLuta(){
        setVitorias(getVitorias()+1);
    }
    
    public void perderLuta(){
        setDerrotas(getDerrotas()+1);
    }
    
    public void empatarLuta(){
        setEmpates(getEmpates()+1);
    
    }
    
}
