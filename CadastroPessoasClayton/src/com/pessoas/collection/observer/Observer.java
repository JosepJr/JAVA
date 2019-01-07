package com.pessoas.collection.observer;

import java.util.TreeSet;
import com.pessoas.model.Pessoa;

public interface Observer {

    public void update(TreeSet<Pessoa> pessoas);
}
