package com.clientes.validador;

import com.clientes.validador.model.Documento;

public abstract class ValidadorDocumento {

    protected String documento;
    protected IApoioDocumento apoio;

    public ValidadorDocumento() {
    }

    public boolean eValido(String documento) throws Exception {

        if (apoio.validar(documento)) {
            this.documento = documento;
            return true;
        }

        return false;
    }

    public abstract Documento cria() throws Exception;

}
