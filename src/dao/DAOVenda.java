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
import model.ModelItemVenda;
import model.ModelVenda;

/**
 *
 * @author joao
 */
public class DAOVenda {

    public void insert(ModelVenda item) throws SQLException {
        String sql = "INSERT INTO venda(cpfCliente, nomeCliente, qtdItens, subTotal, metodoPgto, data_hora)"
                + "VALUES (?,?,?,?,?,?)";
        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, item.getCpfCliente());
            stmt.setString(2, item.getNomeCliente());
            stmt.setInt(3, item.getQtdItens());
            stmt.setFloat(4, item.getSubTotal());
            stmt.setString(5, item.getMetodoPgto());
            stmt.setString(6, item.getDataHora());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAOVenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
    }

    public int getMaxIdVenda() throws SQLException {
        String sql = "SELECT MAX(idVenda) idVenda FROM itemvenda";

        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        int max = 0;

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                max = rs.getInt("idVenda");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOVenda.class.getName()).log(Level.SEVERE, null, ex);
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

        return max;
    }

    public List<ModelItemVenda> selectItemVenda(ModelItemVenda item) throws SQLException {
        String sql = "SELECT itemvenda.iditem, itemvenda.idproduto, "
                + "itemvenda.nomeproduto, itemvenda.qtditens, itemvenda.valortotal "
                + "FROM itemvenda WHERE itemvenda.idvenda = ?;";

        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ModelItemVenda> lista = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, getMaxIdVenda());
            rs = stmt.executeQuery();

            while (rs.next()) {
                if (lista == null) {
                    lista = new ArrayList<>();
                }
                ModelItemVenda list = new ModelItemVenda();
                list.setIdItem(rs.getInt("idItem"));
                list.setIdProduto(rs.getInt("idProduto"));
                list.setNomeProduto(rs.getString("nomeProduto"));
                list.setQtdItens(rs.getInt("qtdItens"));
                list.setValorTotal(rs.getFloat("valorTotal"));
                lista.add(list);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOVenda.class.getName()).log(Level.SEVERE, null, ex);
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
        return lista;
    }
    
    public int getQtdItens() throws SQLException {
        String sql = "SELECT SUM(qtdItens) qtdItens FROM itemvenda WHERE idVenda = ?";

        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        int sum = 0;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, getMaxIdVenda());
            rs = stmt.executeQuery();
            while (rs.next()) {
                sum = rs.getInt("qtdItens");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOVenda.class.getName()).log(Level.SEVERE, null, ex);
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

        return sum;
    }
    
    public int getValorTotal() throws SQLException {
        String sql = "SELECT SUM(valorTotal) valorTotal FROM itemvenda WHERE idVenda = ?";

        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        int sum = 0;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, getMaxIdVenda());
            rs = stmt.executeQuery();
            while (rs.next()) {
                sum = rs.getInt("valorTotal");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOVenda.class.getName()).log(Level.SEVERE, null, ex);
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

        return sum;
    }
    
    public boolean verificaCliente(ModelVenda venda) throws SQLException  {
        String sql = "SELECT * FROM cliente WHERE cpf = ?";

        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, venda.getCpfCliente());
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOVenda.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public String getNomeCliente(ModelVenda venda) throws SQLException {
        String sql = "SELECT nome FROM cliente WHERE cpf = ?";

        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String nomeCliente = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, venda.getCpfCliente());
            rs = stmt.executeQuery();
            while (rs.next()) {
                nomeCliente = rs.getString("nome");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOVenda.class.getName()).log(Level.SEVERE, null, ex);
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

        return nomeCliente;
    }
    
    public void removeProduto(ModelItemVenda item) throws SQLException{
        String sql = "DELETE FROM itemvenda WHERE idItem = ?";
        
        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, item.getIdItem());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
    }
    
    public List<ModelVenda> loadVendas() throws SQLException {
        String sql = "SELECT * FROM venda";

        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ModelVenda> lista = null;

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                if (lista == null) {
                    lista = new ArrayList<>();
                }
                ModelVenda list = new ModelVenda();
                list.setIdVenda(rs.getInt("idvenda"));
                list.setCpfCliente(rs.getString("cpfcliente"));
                list.setNomeCliente(rs.getString("nomecliente"));
                list.setQtdItens(rs.getInt("qtditens"));
                list.setSubTotal(rs.getFloat("subtotal"));
                list.setMetodoPgto(rs.getString("metodopgto"));
                list.setDataHora(rs.getString("data_hora"));
                lista.add(list);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOVenda.class.getName()).log(Level.SEVERE, null, ex);
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
        return lista;
    }
    
    public List<ModelItemVenda> loadItensVenda(ModelItemVenda item) throws SQLException {
        String sql = "SELECT * FROM itemvenda WHERE idVenda = ?";

        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ModelItemVenda> lista = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, item.getIdItem());
            rs = stmt.executeQuery();

            while (rs.next()) {
                if (lista == null) {
                    lista = new ArrayList<>();
                }
                ModelItemVenda list = new ModelItemVenda();
                list.setIdItem(rs.getInt("idItem"));
                list.setIdProduto(rs.getInt("idProduto"));
                list.setIdVenda(rs.getInt("idVenda"));
                list.setNomeProduto(rs.getString("nomeProduto"));
                list.setQtdItens(rs.getInt("qtdItens"));
                list.setValorTotal(rs.getFloat("valorTotal"));
                lista.add(list);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOVenda.class.getName()).log(Level.SEVERE, null, ex);
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
        return lista;
    }
}
