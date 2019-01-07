/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.MenuView;

/**
 *
 * @author Harrison
 */
public class MenuPresenter {

    MenuView menuView;

    public MenuPresenter() {
        menuView = new MenuView();

        menuView.getMenuAdicionar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    menuAdicionar();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MenuPresenter.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MenuPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        menuView.getMenuSair().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuView.setVisible(false);
                menuView.dispose();
            }
        });
        menuView.getMenuListar().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    menuListar();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MenuPresenter.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(MenuPresenter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
        menuView.setVisible(true);
    }

    public void menuAdicionar() throws FileNotFoundException, IOException {
        IncluirProdutoPresenter p = new IncluirProdutoPresenter();
    }
    public void menuListar() throws FileNotFoundException, IOException{
       ListarProdutosPresenter p1 = new ListarProdutosPresenter();
    }
}
