/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAOCliente;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ModelCliente;
import view.ViewCadastrarCliente;

/**
 *
 * @author joao
 */
public class ControllerCliente {

    private ViewCadastrarCliente cadastrarCliente;

    public ControllerCliente() {

    }

    public ControllerCliente(ViewCadastrarCliente cadastrarCliente) {
        this.cadastrarCliente = cadastrarCliente;
    }

    public void registraCliente() {
        String cpf = cadastrarCliente.getjTFcpf().getText();
        String nome = cadastrarCliente.getjTFnome().getText();
        String dataNascimento = cadastrarCliente.getjTFDataNasc().getText();
        String cidade = cadastrarCliente.getjTFCidade().getText();
        String bairro = cadastrarCliente.getjTFBairro().getText();
        String rua = cadastrarCliente.getjTFRua().getText();
        String email = cadastrarCliente.getjTFemail().getText();
        int numero = Integer.parseInt(cadastrarCliente.getjTFnumero().getText());

        String sex = (String) cadastrarCliente.jCBxSexo.getSelectedItem();
        String estado = (String) cadastrarCliente.jCBxEstado.getSelectedItem();
        
        char sexo = sex.charAt(0);

        ModelCliente cliente = new ModelCliente(nome, sexo, dataNascimento, cpf, estado,
                cidade, bairro, rua, numero, email);

        try {

            DAOCliente dao = new DAOCliente();
            dao.insert(cliente);

            JOptionPane.showMessageDialog(null, "Cliente com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
