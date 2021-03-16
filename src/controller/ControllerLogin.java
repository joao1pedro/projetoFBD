/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAOLogin;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.ModelLogin;
import view.ViewLogin;
import view.ViewMenu;

/**
 *
 * @author joao
 */
public class ControllerLogin {
    private ViewLogin vLogin;

    public ControllerLogin(ViewLogin vLogin) {
        this.vLogin = vLogin;
    }
    
    protected static String username = null;
    
    public void autentica() throws SQLException{
        username = vLogin.jTFusername.getText();
        String password = new String(vLogin.jPFpassword.getPassword());
        
        ModelLogin user = new ModelLogin(username, password);
        DAOLogin dao = new DAOLogin();
        
        if(dao.verificaAutenticidade(user)){
   
            ViewMenu m = new ViewMenu();
            m.setVisible(true);
            vLogin.dispose();
        } else{
            JOptionPane.showMessageDialog(null, "Falha ao fazer login"); 
        }
    }
}
