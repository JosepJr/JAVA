package com.clientes.validador.model;

public abstract class Documento {

    protected String codigo;
    protected String tipo;

    public Documento(String codigo) throws Exception {
        this.codigo = codigo;
    }

    public abstract String getCodigo(boolean formatado) throws Exception;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
