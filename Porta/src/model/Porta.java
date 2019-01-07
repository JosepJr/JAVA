package model;

import State.PortaState;
import State.Trancada;

public class Porta {

    PortaState estado;

    public Porta() {
        this.setState(new Trancada(this));
    }

    public void abrir() {
        try {
            estado.abrir();
        } catch (Exception e) {
            System.out.println("Esta porta não pode ser aberta, pois ela está " + estado.getClass().getSimpleName().toLowerCase());
        }
    }

    public void fechar() {
        try {
            estado.fechar();
        } catch (Exception e) {
            System.out.println("Esta porta não pode ser fechada, pois ela está " + estado.getClass().getSimpleName().toLowerCase());
        }
    }

    public void trancar() {
        try {
            estado.trancar();
        } catch (Exception e) {
            System.out.println("Esta porta não pode ser trancada, pois ela está " + estado.getClass().getSimpleName().toLowerCase());
        }
    }

    public void destrancar() {
        try {
            estado.destrancar();
        } catch (Exception e) {
            System.out.println("Esta porta não pode ser destrancada, pois ela está " + estado.getClass().getSimpleName().toLowerCase());
        }
    }

    public void setState(PortaState estado) {
        this.estado = estado;
    }

    public PortaState getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Esta porta está " + estado.getClass().getSimpleName().toLowerCase() + ".";
    }

}
