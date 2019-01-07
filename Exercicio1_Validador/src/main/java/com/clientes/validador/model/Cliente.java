package com.clientes.validador.model;

import com.clientes.validador.ProcessadorDocumento;

public final class Cliente {

    private String nome;
    private Documento documento;

    public Cliente(String nome, String documento) throws Exception {
        setNome(nome);
        setDocumento(documento);
    }

    public String getDocumento(boolean formatado) throws Exception {
        return documento.getCodigo(formatado);
    }

    public String getTipoDocumento() throws Exception {
        return documento.getTipo();
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) throws Exception {
        try {

            if (nome.isEmpty()) {
                throw new Exception("Informe um nome válido!");
            }
            this.nome = nome;
        } catch (Exception e) {
            throw e;
        }

    }

    public void setDocumento(String documento) throws Exception {
        this.documento = ProcessadorDocumento.getInstance().processar(documento);
    }

    @Override
    public String toString() {
        try {
            return "Nome: " + this.nome + ", documento: " + this.documento.getCodigo(true) + ", tipoo:" + this.documento.getTipo();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
