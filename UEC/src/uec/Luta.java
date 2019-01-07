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
public class Luta {
    
    private Lutador desafiado;
    private Lutador desafiante;
    private int rounds;
    private boolean aprovada;

    public Lutador getDesafiado() {
        return desafiado;
    }

    public void setDesafiado(Lutador desafiado) {
        this.desafiado = desafiado;
    }

    public Lutador getDesafiante() {
        return desafiante;
    }

    public void setDesafiante(Lutador desafiante) {
        this.desafiante = desafiante;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public boolean isAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }
    
    
    public void marcarLuta(Lutador desafiado, Lutador desafiante){
        if(desafiado.getCategoria().equals(desafiante.getCategoria()) && (desafiado != desafiante)){
            this.aprovada = true;
            this.desafiado = desafiado;
            this.desafiante = desafiante;
        }
        else{
            this.aprovada = false;
            this.desafiado = null;
            this.desafiante = null;
        }
    }
    public void lutar(){
        if(this.aprovada == true){
            System.out.println("####DESAFIADO#####");
            this.desafiado.apresentar();
            System.out.println("####DESAFIANTE#####");
            this.desafiante.apresentar();
            double ale = Math.random();
            int n = (int) (3 + ale *(0-3));
            System.out.print("Numero Random: ");
            System.out.println(n);
            switch(n){
                case(0):            
                System.out.println("LUTA EMPATADA!!!!\n");
                this.desafiante.empatarLuta();
                this.desafiado.empatarLuta();
                break;                              
                case(1):
                System.out.println("Desafiante Ganhou!!!!\n");
                this.desafiante.ganharLuta();
                this.desafiado.perderLuta();
                break;               
                case(2):
                System.out.println("Desafiado Ganhouuu!!!\n");
                this.desafiado.ganharLuta();
                this.desafiante.perderLuta();
                break;
            }
        }
        else{
            System.out.println("Luta não pode acontecer...\n");
        }
            
    }
}
