package com.pessoas.model;

import java.io.Serializable;
import java.util.Observable;

public class Pessoa extends Observable implements Comparable<Pessoa>, Serializable {

    private String nome;
    private String telefone;

    public void setNome(String nome) {
        this.nome = nome;
        setChanged();
        notifyObservers();
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
        setChanged();
        notifyObservers();
    }

    public Pessoa(String pNome, String pTelefone) {
        this.nome = pNome;
        this.telefone = pTelefone;
        setChanged();
        notifyObservers();
    }

    public String getNome() {
        return this.nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    @Override
    public String toString() {
        return "" + this.nome
                + "," + this.telefone;
    }

    @Override
    public int compareTo(Pessoa o) {
        return nome.compareTo(o.nome);
    }
}
