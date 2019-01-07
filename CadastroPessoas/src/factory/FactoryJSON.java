/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import adapter.ILog;
import adapter.JSONLog;

/**
 *
 * @author Josep
 */
public class FactoryJSON implements IFactory{

    @Override
    public ILog criarLog() {
        return JSONLog.getInstance();
    }
    
}
