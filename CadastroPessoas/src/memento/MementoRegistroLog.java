/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memento;

import java.util.Date;
import model.Cliente;


/**
 *
 * @author Josep
 */
public class MementoRegistroLog {
    protected Cliente cliente;
    protected Cliente clienteatualzado;
    protected Date data;
    protected String operacao;
    protected String usuario;

    public MementoRegistroLog(Cliente cliente, Cliente clienteatualzado, Date data, String operacao, String usuario) {
        this.cliente = cliente;
        this.clienteatualzado = clienteatualzado;
        this.data = data;
        this.operacao = operacao;
        this.usuario = usuario;
    }    

    public Cliente getCliente() {
        return cliente;
    }

    public Cliente getClienteatualzado() {
        return clienteatualzado;
    }

    public Date getData() {
        return data;
    }

    public String getOperacao() {
        return operacao;
    }

    public String getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return "MementoRegistroLog{" + "cliente=" + cliente + ", clienteatualzado=" + clienteatualzado + ", data=" + data + ", operacao=" + operacao + ", usuario=" + usuario + '}';
    }
   
    
    
}
