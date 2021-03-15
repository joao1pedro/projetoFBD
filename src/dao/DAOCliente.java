/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModelCliente;

/**
 *
 * @author joao
 */
public class DAOCliente {

    public void insert(ModelCliente cliente) throws SQLException {
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

    public List<ModelCliente> consultaCliente() throws SQLException {
        String sql = "SELECT * FROM cliente";

        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ModelCliente> clientes = null;

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                if (clientes == null) {
                    clientes = new ArrayList<>();
                }
                ModelCliente cliente = new ModelCliente();
                cliente.setCpf(rs.getString("cpf"));
                cliente.setNome(rs.getString("nome"));
                cliente.setSexo(rs.getString("sexo").charAt(0));
                cliente.setDataNascimento(rs.getString("data_nascimento"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setCidade(rs.getString("cidade"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setRua(rs.getString("rua"));
                cliente.setNumero(rs.getInt("numero"));
                cliente.setEmail(rs.getString("email"));

                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
        return clientes;
    }

    public List<ModelCliente> procurar(ModelCliente cliente) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE nome LIKE (?)";

        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ModelCliente> clientes = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + cliente.getNome() + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                if (clientes == null) {
                    clientes = new ArrayList<>();
                }
                ModelCliente cli = new ModelCliente();
                cli.setCpf(rs.getString("cpf"));
                cli.setNome(rs.getString("nome"));
                cli.setSexo(rs.getString("sexo").charAt(0));
                cli.setDataNascimento(rs.getString("data_nascimento"));
                cli.setEstado(rs.getString("estado"));
                cli.setCidade(rs.getString("cidade"));
                cli.setBairro(rs.getString("bairro"));
                cli.setRua(rs.getString("rua"));
                cli.setNumero(rs.getInt("numero"));
                cli.setEmail(rs.getString("email"));
                clientes.add(cli);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
        return clientes;
    }

    public boolean verificaCliente(ModelCliente cliente) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE nome = ?";

        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            rs = stmt.executeQuery();

            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
        return false;
    }

    public void updateCliente(ModelCliente cliente) throws SQLException {
        String sql = "UPDATE cliente SET nome = ?, "
                + "sexo = ?, data_nascimento = ?, estado = ?,"
                + "cidade = ?, bairro = ?, rua = ?, numero = ?,"
                + "email = ? WHERE cpf = ?;";

        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, String.valueOf(cliente.getSexo()));
            stmt.setString(3, cliente.getDataNascimento());
            stmt.setString(4, cliente.getEstado());
            stmt.setString(5, cliente.getCidade());
            stmt.setString(6, cliente.getBairro());
            stmt.setString(7, cliente.getRua());
            stmt.setInt(8, cliente.getNumero());
            stmt.setString(9, cliente.getEmail());
            stmt.setString(10, cliente.getCpf());

            stmt.executeUpdate();
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

    public void removeCliente(ModelCliente cliente) throws SQLException {
        String sql = "DELETE FROM cliente  WHERE nome = ?";

        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.executeUpdate();     
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
