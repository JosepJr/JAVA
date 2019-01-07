/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pessoas.controller;

import java.util.Comparator;
import com.pessoas.model.Pessoa;

/**
 *
 * @author Clayton
 */
public class ComparadorDeTelefonePessoa implements Comparator<Pessoa> {

    @Override
    public int compare(Pessoa aPerson, Pessoa anotherPerson) {
        return aPerson.getTelefone().compareTo(anotherPerson.getTelefone());
    }
}
