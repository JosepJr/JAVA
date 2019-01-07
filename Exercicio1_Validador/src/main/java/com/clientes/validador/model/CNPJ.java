package com.clientes.validador.model;

import com.clientes.validador.CNPJApoioDocumento;

public class CNPJ extends Documento {

    public CNPJ(String cnpj) throws Exception {
        super(cnpj);
        if (CNPJApoioDocumento.getInstance().validar(cnpj)) {
            this.codigo = cnpj;
        }
        this.tipo = "CNPJ";
    }

    @Override
    public String getCodigo(boolean formatado) throws Exception {
        if (formatado) {
            return CNPJApoioDocumento.getInstance().formata(codigo);
        }
        return codigo;
    }
}
