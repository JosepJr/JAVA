/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculobonussalario;

import java.util.ArrayList;

public abstract class Funcionario {
    private String nome;
    private double salarioBase;
    private double salarioTotal;
    private int falta;
    private String estado;
    public ArrayList <Bonus> bonusRecebidos = new ArrayList <>();
       
public Funcionario(String nome, double salarioBase, int falta, String estado, Bonus bonus){
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.falta = falta;
        this.estado = estado;
        this.bonusRecebidos.add(bonus);
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }
    
    public void setFaltas(int falta){
        this.falta = falta;
    }
    
    public int getFaltas(){
        return this.falta;
    }
    
    public void setSalarioBase(double salarioBase){
        this.salarioBase = salarioBase;
    }
    
    public double getSalarioBase(){
        return this.salarioBase;
    }

    public double getSalarioTotal() {
        return salarioTotal;
    }

    public void setSalarioTotal(double salarioTotal) {
        this.salarioTotal = salarioTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void setBonusRecebidos(Bonus bonus){
        this.bonusRecebidos.add(bonus);
    }
     
    public ArrayList<Bonus> getBonusRecebidos(){
        return this.bonusRecebidos;  
    }
    
    public boolean recebeuBonus(){
        if (!this.bonusRecebidos.isEmpty()){
            if(this.bonusRecebidos.get(0).getNome().equalsIgnoreCase("Generoso") || this.bonusRecebidos.get(0).getNome().equalsIgnoreCase("normal")){
                return true;
            }
       }
       return false;
    }
    
    public void addBonus(Bonus bonus){
        if(!this.bonusRecebidos.contains(bonus)){
            this.bonusRecebidos.add(bonus);
        }
   }
       
    public void calcularSalario(){
    
    }
        
    @Override
    public String toString() {
        return "Funcionario{" + "nome=" + nome + ", salarioBase=" + salarioBase + ", salarioTotal=" + salarioTotal + ", falta=" + falta + ", estado=" + estado + ", bonusRecebidos=" + bonusRecebidos + '}';
    }

}