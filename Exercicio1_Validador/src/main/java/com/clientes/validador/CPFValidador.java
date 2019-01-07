package com.clientes.validador;

import com.clientes.validador.model.CPF;
import com.clientes.validador.model.Documento;

public class CPFValidador extends ValidadorDocumento {

    public CPFValidador() {
        apoio = CPFApoioDocumento.getInstance();
    }

    @Override
    public Documento cria() throws Exception {
        return new CPF(this.documento);
    }

}
