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
import view.ViewConsultarCliente;

/**
 *
 * @author joao
 */
public class ControllerCliente {

    private ViewCadastrarCliente cadastrarCliente;
    private ViewConsultarCliente consultarCliente;

    public ControllerCliente() {

    }

    public ControllerCliente(ViewConsultarCliente consultarCliente) {
        this.consultarCliente = consultarCliente;
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

    public void consultaCliente() {
        try {
            DAOCliente dao = new DAOCliente();

            if (dao.consultaCliente() == null) {
                consultarCliente.table.setNumRows(0);
            } else {

                for (ModelCliente c : dao.consultaCliente()) {
                    consultarCliente.table.addRow(new Object[]{
                        c.getCpf(),
                        c.getNome(),
                        c.getSexo(),
                        c.getDataNascimento(),
                        c.getEstado(),
                        c.getCidade(),
                        c.getBairro(),
                        c.getRua(),
                        c.getNumero(),
                        c.getEmail()
                    });
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ViewConsultarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void procurar() throws SQLException {
        String nome = consultarCliente.getjTFnmCliente().getText();

        ModelCliente cliente = new ModelCliente(nome);
        DAOCliente dao = new DAOCliente();

        if (dao.procurar(cliente) == null) {
            consultaCliente();
        } else {
            try {
                for (ModelCliente c : dao.procurar(cliente)) {
                    consultarCliente.table.addRow(new Object[]{
                        c.getCpf(),
                        c.getNome(),
                        c.getSexo(),
                        c.getDataNascimento(),
                        c.getEstado(),
                        c.getCidade(),
                        c.getBairro(),
                        c.getRua(),
                        c.getNumero(),
                        c.getEmail()
                    });
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void selecionaLinha() {
        int row = consultarCliente.jTableClientes.getSelectedRow();

        String cpf = consultarCliente.table.getValueAt(row, 0).toString();
        String nome = consultarCliente.table.getValueAt(row, 1).toString();
        String nascimento = consultarCliente.table.getValueAt(row, 3).toString();
        String cidade = consultarCliente.table.getValueAt(row, 5).toString();
        String bairro = consultarCliente.table.getValueAt(row, 6).toString();
        String rua = consultarCliente.table.getValueAt(row, 7).toString();
        int numero = (int) consultarCliente.jTableClientes.getValueAt(row, 8);
        String email = consultarCliente.table.getValueAt(row, 9).toString();

        String stringNumero = String.valueOf(numero);

        consultarCliente.jTFnomeAlt.setText(nome);
        consultarCliente.jTFnascimento.setText(nascimento);
        consultarCliente.jTFcidade.setText(cidade);
        consultarCliente.jTFbairro.setText(bairro);
        consultarCliente.jTFrua.setText(rua);
        consultarCliente.jTFnumero.setText(stringNumero);
        consultarCliente.jTFemail.setText(email);
        consultarCliente.jTFcpf.setText(cpf);
    }

    public void updateProduto() {

        String cpf = consultarCliente.jTFcpf.getText();
        String nome = consultarCliente.jTFnomeAlt.getText();
        String nascimento = consultarCliente.jTFnascimento.getText();
        String cidade = consultarCliente.jTFcidade.getText();
        String bairro = consultarCliente.jTFbairro.getText();
        String rua = consultarCliente.jTFrua.getText();
        int numero = Integer.parseInt(consultarCliente.jTFnumero.getText());
        String email = consultarCliente.jTFemail.getText();
        String estado = consultarCliente.jCBxEstado.getSelectedItem().toString();
        
        String sex = (String) consultarCliente.jCBxSexo.getSelectedItem();
        char sexo = sex.charAt(0);
        
        ModelCliente cliente = new ModelCliente(nome, sexo, nascimento, cpf, estado, cidade,
                bairro, rua, numero, email);
        
        try {
            DAOCliente dao = new DAOCliente();
            dao.updateCliente(cliente);
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void removeProduto() {
        int row = consultarCliente.jTableClientes.getSelectedRow();
        String nome = consultarCliente.table.getValueAt(row, 1).toString();

        ModelCliente cliente = new ModelCliente(nome);

        try {
            DAOCliente dao = new DAOCliente();
            dao.removeCliente(cliente);
            JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ControllerCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
