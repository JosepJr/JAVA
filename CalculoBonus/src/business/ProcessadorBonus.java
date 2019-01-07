/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import model.Funcionario;

/**
 *
 * @author Harrison
 */
public class ProcessadorBonus {

    ArrayList<BonusTratador> tratadores = new ArrayList<>();

    public ProcessadorBonus() {
        add(new AssiduidadeTratador());
        add(new GenerosoTratador());
        add(new NormalTratador());
    }

    private void add(BonusTratador p) {
        tratadores.add(p);
    }

    public void processar(Funcionario f) {
        double total = 0;
        for (BonusTratador t : tratadores) {
            if (t.aceitar(f)) {
                total += t.calcular(f);
            }
        }
        f.setSalarioTotal(total);
    }

}
