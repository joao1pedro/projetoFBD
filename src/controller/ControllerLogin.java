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
import view.ViewRelatorioVendas;
import view.ViewVerificaAutenticacaoUsuario;

/**
 *
 * @author joao
 */
public class ControllerLogin {
    private ViewLogin vLogin;
    private ViewVerificaAutenticacaoUsuario vPermissao;

    public ControllerLogin(ViewLogin vLogin) {
        this.vLogin = vLogin;
    }

    public ControllerLogin(ViewVerificaAutenticacaoUsuario vPermissao) {
        this.vPermissao = vPermissao;
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
    
    public void verificaPermissao() throws SQLException{
        username = vPermissao.getjTFlogin().getText();
        String password = new String(vPermissao.getjPasswordField().getPassword());
        
        ModelLogin user = new ModelLogin(username, password);
        DAOLogin dao = new DAOLogin();
        
        if(dao.verificaPermissao(user)){
            ViewRelatorioVendas relatorio = new ViewRelatorioVendas();
            relatorio.setVisible(true);
            vPermissao.dispose();
        } else{
            JOptionPane.showMessageDialog(null, "Usuário não possui permissão para acessar relatórios de vendas "
                    + "ou login e/ou senha incorretos.");
        }
    }
}
