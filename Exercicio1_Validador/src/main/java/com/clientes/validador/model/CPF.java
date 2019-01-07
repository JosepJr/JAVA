package com.clientes.validador.model;

import com.clientes.validador.CPFApoioDocumento;

public class CPF extends Documento {

    public CPF(String cpf) throws Exception {
        super(cpf);
        if (CPFApoioDocumento.getInstance().validar(cpf)) {
            this.codigo = cpf;
        }
        this.tipo = "CPF";
    }

    @Override
    public String getCodigo(boolean formatado) throws Exception {
        if (formatado) {
            return CPFApoioDocumento.getInstance().formata(codigo);
        }
        return codigo;
    }

}
