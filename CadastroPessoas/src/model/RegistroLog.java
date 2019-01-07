/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Calendar;
import java.util.Date;
import memento.MementoRegistroLog;
import memento.RegistroLogZelador;

/**
 *
 * @author Josep
 */
public class RegistroLog {
    protected Cliente cliente;
    protected Cliente clienteatualzado;
    protected Date data;
    protected String operacao;
    protected String usuario;
    protected RegistroLogZelador zelador;

    public RegistroLog(Usuario usuario,String operacao, Cliente cliente ) {
        this.cliente = cliente;
        this.data = Calendar.getInstance().getTime();
        this.operacao = operacao;
        this.usuario = usuario.getUsuario();
        this.inserirMemento();
    }
    
    public RegistroLog(Usuario usuario,String operacao, Cliente clienteDesatualizado, Cliente clienteAtualizado ) {
        this.cliente = clienteDesatualizado;
        this.data = Calendar.getInstance().getTime();
        this.operacao = operacao;
        this.usuario = usuario.getUsuario();
        this.clienteatualzado = clienteAtualizado;
        this.inserirMemento();
    }
    
    
    private void inserirMemento(){
        zelador = RegistroLogZelador.getInstance();
        zelador.adicionarMemento(new MementoRegistroLog(this.cliente, this.clienteatualzado, this.data, this.operacao, this.usuario));
    }

    public RegistroLog desfazer() throws Exception{
        this.cliente = zelador.getUltimoEstadoSalvo().getCliente();
        this.data = zelador.getUltimoEstadoSalvo().getData();
        this.operacao = zelador.getUltimoEstadoSalvo().getOperacao();
        this.usuario = zelador.getUltimoEstadoSalvo().getUsuario();
        this.clienteatualzado = zelador.getUltimoEstadoSalvo().getClienteatualzado();
        return this;
    }
    
    @Override
    public String toString() {
        return "RegistroLog{" + "cliente=" + cliente + ", clienteatualzado=" + clienteatualzado + ", data=" + data + ", operacao=" + operacao + ", usuario=" + usuario + '}';
    }

}
