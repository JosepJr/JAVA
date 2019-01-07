/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;
import dao.ClienteDAOTXT;
import adapter.JSONLog;
import adapter.XMLLog;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Cliente;
import model.RegistroLog;
import model.Usuario;
import presenter.LoginPresenter;
import view.LoginView;
/**
 *
 * @author Josep
 */
public class NewClass {
    
    
    public static void main(String args[]){
   
        
        
        try {        
            
            
            //new Cliente("José Paulo de Amorim","14155483742","(28)99999-9999");
            //new Cliente("José","94125852766","(28)99999-9999");
            //new Cliente("Amorim","83663376770","(28)99999-9999");
            //new Cliente("Paulo de Amorim","70136074790","(28)99999-9999");
            //new Cliente("Paulo","52660313792","(28)99999-9999");
            //new Cliente("José Paulo","59617825732","(28)99999-9999");
            //new Cliente("Adoleta","45244844776","(28)99999-9999");
            //new Cliente("Fransciscano","12050870795","(28)99999-9999");
            
            
            /*ClienteDAOTXT.getInstance().insertCliente(new Cliente("Fransciscano","12050870795","(28)99999-9999"));
            ClienteDAOTXT.getInstance().insertCliente(new Cliente("José Paulo de Amorim","14155483742","(28)99999-9999"));
            ClienteDAOTXT.getInstance().insertCliente(new Cliente("José","94125852766","(28)99999-9999"));
            ClienteDAOTXT.getInstance().insertCliente(new Cliente("Amorim","83663376770","(28)99999-9999"));
            ClienteDAOTXT.getInstance().insertCliente(new Cliente("Paulo de Amorim","70136074790","(28)99999-9999"));
            ClienteDAOTXT.getInstance().insertCliente(new Cliente("Paulo","52660313792","(28)99999-9999"));
            ClienteDAOTXT.getInstance().insertCliente(new Cliente("José Paulo","59617825732","(28)99999-9999"));
            ClienteDAOTXT.getInstance().insertCliente(new Cliente("Adoleta","45244844776","(28)99999-9999"));           
            ClienteDAOTXT.getInstance().insertCliente(new Cliente("Frao","72656665779","(28)99999-9999"));
            ClienteDAOTXT.getInstance().insertCliente(new Cliente("ronaldinho dos rolé","50114170002","(28)99999-9999"));*/
            //ClienteDAOTXT.getInstance().insertCliente(new Cliente("José Paulo de Amorim Júnior","26890737067","(28)99999-9999"));          
            //ClienteDAOTXT.getInstance().deleteCliente(new Cliente("aaaaaaaaaaaaaaaaaaaaaa","54357900000","(28)99999-9999"));
            //ClienteDAOTXT.getInstance().updateCliente(new Cliente(), new Cliente());
            //ClienteDAOTXT.getInstance().deleteCliente(new Cliente("José Paulo","59617825732","(28)99999-9999"));
            //System.out.println(ClienteDAOTXT.getInstance().getListaClientes().toString());
            //ClienteDAOTXT.getInstance().updateCliente(new Cliente("Fransciscano","12050870795","(28)99999-9999"), new Cliente("Fraaeaweo","32117649092","(28)99999-9999"));
            //ClienteDAOTXT.getInstance().updateCliente(new Cliente("Fransciscano","14155483742","(28)99999-9999"), new Cliente("JOSÉ PAULO DE AMORIM JUNIOR","70136074790","(28)99999-9999"));
            
            
           // JSONLog.getInstance().lerJson();
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        
        
        
       LoginPresenter.getInstance();
    
        
    
    }    
}
