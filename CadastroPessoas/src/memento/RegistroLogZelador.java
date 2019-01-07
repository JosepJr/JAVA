/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memento;

import java.util.ArrayList;

/**
 *
 * @author Josep
 */
public class RegistroLogZelador {
    
    protected ArrayList<MementoRegistroLog> estados;
    protected static RegistroLogZelador instance;
    
    
    private RegistroLogZelador(){
        estados = new ArrayList<>();
    }
    
    public static RegistroLogZelador getInstance(){
        if(instance == null){
            instance = new RegistroLogZelador();
        }
        return instance;
    }
    
    public void adicionarMemento(MementoRegistroLog memento){
        estados.add(memento);
    }
    
    public MementoRegistroLog getUltimoEstadoSalvo() throws Exception{
        if(estados.size() <= 0){
            throw new Exception("Não existe estados a serem recuperados");
        }
        MementoRegistroLog estadoSalvo = estados.get(estados.size()-1);
        return estadoSalvo;
    }
    
    public void desempilhar(){
        this.estados.remove(estados.size()-1);
    }
  
}
