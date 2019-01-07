package com.clientes.validador;

public interface IApoioDocumento {

    String formata(String codigo) throws Exception;

    String gerar(boolean comPontos);

    boolean validar(String codigo) throws Exception;

}
