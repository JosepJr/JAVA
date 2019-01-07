package com.clientes.validador;

import com.clientes.validador.model.CNPJ;
import com.clientes.validador.model.Documento;

public class CNPJValidador extends ValidadorDocumento {

    public CNPJValidador() {
        apoio = CNPJApoioDocumento.getInstance();
    }

    @Override
    public Documento cria() throws Exception {
        return new CNPJ(this.documento);
    }

}
