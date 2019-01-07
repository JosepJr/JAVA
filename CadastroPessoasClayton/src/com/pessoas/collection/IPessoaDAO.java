package com.pessoas.collection;

import com.pessoas.collection.observer.Observer;
import com.pessoas.model.Pessoa;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;

public abstract class IPessoaDAO<T> {

    protected ArrayList<Observer> observadores = new ArrayList<Observer>();

    public abstract boolean add(Pessoa p) throws IOException;

    public abstract void addAll(TreeSet<Pessoa> pessoas) throws IOException;

    public abstract void addObserver(Observer observer);

    public abstract boolean altera(Pessoa pessoaExistente, String nomeAnterior) throws IOException;

    public abstract void carregaPessoas() throws FileNotFoundException;

    public abstract boolean contains(Pessoa p);

    public abstract Pessoa getPessoaByName(String nome);

    public abstract TreeSet<Pessoa> getTreeSet();

    public abstract void notifyObservers();

    public abstract boolean remove(String nome) throws IOException;
}
