/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ConnectionFactory;
import dao.DAOProduto;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ModelProduto;
import view.ViewCadastrarProduto;
import view.ViewConsultarProduto;

/**
 *
 * @author joao
 */
public class ControllerProduto {

    private ViewCadastrarProduto view;
    private ViewConsultarProduto viewConsultarP;

    public ControllerProduto(ViewConsultarProduto viewConsultarP) {
        this.viewConsultarP = viewConsultarP;
    }

    public ControllerProduto(ViewCadastrarProduto view) {
        this.view = view;
    }

    public void registraProduto() {
        String nome = view.getjTFNome().getText();
        int quantidade = Integer.parseInt(view.getjTFQuantidade().getText());
        float custo = Float.parseFloat(view.getjTFCusto().getText());
        float valor = Float.parseFloat(view.getjTFValor().getText());

        ModelProduto produto = new ModelProduto(nome, quantidade, custo, valor);
        try {
            Connection con = new ConnectionFactory().getConnection();
            DAOProduto daoProduto = new DAOProduto(con);
            daoProduto.insert(produto);

            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ViewCadastrarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void consultaProduto(){
        Connection con;
        
        try {
            con = new ConnectionFactory().getConnection();
            DAOProduto daop = new DAOProduto(con);
            
            for(ModelProduto p: daop.consultaProduto()){
                viewConsultarP.table.addRow(new Object[]{
                    p.getId(),
                    p.getNome(),
                    p.getQuantidade(),
                    p.getCusto(),
                    p.getValor()
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewConsultarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void consultaNomeProduto(){
        Connection con;
        
        String nome = viewConsultarP.getjTFNmProduto().getText();
        
        ModelProduto produto = new ModelProduto(nome);
        
        try {
            con = new ConnectionFactory().getConnection();
            DAOProduto daop = new DAOProduto(con);
            daop.consultaProduto(produto);
            
            for(ModelProduto p: daop.consultaProduto()){
                viewConsultarP.table.addRow(new Object[]{
                    p.getId(),
                    p.getNome(),
                    p.getQuantidade(),
                    p.getCusto(),
                    p.getValor()
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewConsultarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
