/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModelCliente;

/**
 *
 * @author joao
 */
public class DAOCliente {
    public void insert(ModelCliente cliente) throws SQLException{
        String sql = "INSERT INTO CLIENTE(cpf, nome, sexo, data_nascimento, estado,"
                + "cidade, bairro, rua, numero, email) VALUES(?,?,?,?,?,?,?,?,?,?)";
        
        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, String.valueOf(cliente.getSexo()));
            stmt.setString(4, cliente.getDataNascimento());
            stmt.setString(5, cliente.getEstado());
            stmt.setString(6, cliente.getCidade());
            stmt.setString(7, cliente.getBairro());
            stmt.setString(8, cliente.getRua());
            stmt.setInt(9, cliente.getNumero());
            stmt.setString(10, cliente.getEmail());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
    }
}
