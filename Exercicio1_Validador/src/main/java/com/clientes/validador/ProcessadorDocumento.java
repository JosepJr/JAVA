package com.clientes.validador;

import com.clientes.validador.model.Documento;
import java.util.ArrayList;

public class ProcessadorDocumento {

    private static ProcessadorDocumento instance;

    private ArrayList<ValidadorDocumento> validadores;

    private ProcessadorDocumento() {
        validadores = new ArrayList<>();

        validadores.add(new CNPJValidador());
        validadores.add(new CPFValidador());
    }

    public static ProcessadorDocumento getInstance() {
        if (instance == null) {
            instance = new ProcessadorDocumento();
        }
        return instance;
    }

    public Documento processar(String documento) throws Exception {
        for (ValidadorDocumento validador : validadores) {
            if (validador.eValido(documento)) {
                return validador.cria();
            }
        }
        throw new Exception("Não foi possível criar um documento");
    }

}
