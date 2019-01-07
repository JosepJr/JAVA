/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import decorator.Decorado;
import decorator.Sanduiche;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Josep
 */
public class ProcessadorSanduiche {

    private static ProcessadorSanduiche instance;
    private final ArrayList<Decorado> ingredientes;

    private ProcessadorSanduiche() {
        this.ingredientes = new ArrayList<>();
    }

    public static ProcessadorSanduiche getInstance() {
        if (instance == null) {
            instance = new ProcessadorSanduiche();
        }
        return instance;
    }

    public void addIngrediente(Decorado decorado) {
        this.ingredientes.add(decorado);
    }

    public ArrayList<Decorado> removerIngrediente(ArrayList<String> elementosRemover) {

        for(int j = 0; j < elementosRemover.size(); j++){
            for (Iterator<Decorado> i = ingredientes.iterator(); i.hasNext();) {
                Sanduiche sand = i.next();
                if (sand.getDescricao().equalsIgnoreCase(elementosRemover.get(j))) {
                    i.remove();
                }
            }
        }
        return this.ingredientes;
    }

    public ArrayList<Decorado> getSanduiches() {
        return ingredientes;
    }

}
