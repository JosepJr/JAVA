/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import dao.ClienteDAOSQLite;
import dao.ClienteDAOTXT;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import memento.RegistroLogZelador;
import model.Cliente;
import presenter.BuscarClientePresenter;
import presenter.ManterClientePresenter;
import memento.MementoRegistroLog;

/**
 *
 * @author Josep
 */
public class BuscarClienteCommand implements ICommand{

    private static BuscarClienteCommand instance;

    private BuscarClienteCommand() {

    }

    public static BuscarClienteCommand getInstance() {
        if (instance == null) {
            instance = new BuscarClienteCommand();
        }
        return instance;
    }

    @Override
    public void executar(ManterClientePresenter presenter, Cliente cliente) {
    }

    @Override
    public void desfazer(BuscarClientePresenter presenter) {
        try{
            MementoRegistroLog mementoregistrolog = RegistroLogZelador.getInstance().getUltimoEstadoSalvo();
            UIManager.put("OptionPane.yesButtonText", "Sim");
            UIManager.put("OptionPane.noButtonText", "Não");
            switch (JOptionPane.showConfirmDialog(null, "Deseja desfazer a ultima ação realizada " + mementoregistrolog.getOperacao() + "?", "Confirmação de desfazer", JOptionPane.YES_NO_OPTION)) {
                case 0:
                    switch(mementoregistrolog.getOperacao()){
                        case "DELETE":
                            ClienteDAOSQLite.getInstance().insert(mementoregistrolog.getCliente());
                            ClienteDAOTXT.getInstance().insert(mementoregistrolog.getCliente());
                            RegistroLogZelador.getInstance().desempilhar();
                            break;
                        case "INSERT":
                            ClienteDAOSQLite.getInstance().delete(mementoregistrolog.getCliente());
                            ClienteDAOTXT.getInstance().delete(mementoregistrolog.getCliente());
                            RegistroLogZelador.getInstance().desempilhar();                            
                            break;
                        case "UPDATE":
                            ClienteDAOSQLite.getInstance().update(mementoregistrolog.getClienteatualzado(), mementoregistrolog.getCliente());
                            ClienteDAOTXT.getInstance().update(mementoregistrolog.getClienteatualzado(), mementoregistrolog.getCliente());
                            RegistroLogZelador.getInstance().desempilhar();
                            break;
                    }
                    break;
                case 1:
                    break;
            }
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
}