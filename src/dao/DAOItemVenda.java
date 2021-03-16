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

/**
 *
 * @author joao
 */
public class DAOItemVenda {

    public List<ModelItemVenda> consultaProduto() throws SQLException {
        String sql = "SELECT * FROM produto";

        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ModelItemVenda> produtos = null;

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                if (produtos == null) {
                    produtos = new ArrayList<>();
                }
                ModelItemVenda produto = new ModelItemVenda();
                produto.setIdProduto(rs.getInt("cod_prod"));
                produto.setNomeProduto(rs.getString("nome"));
                produto.setQtdItens(rs.getInt("quantidade"));
                produto.setValorTotal(rs.getFloat("valor"));
                produtos.add(produto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOItemVenda.class.getName()).log(Level.SEVERE, null, ex);
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
        return produtos;
    }

    public List<ModelItemVenda> procurar(ModelItemVenda item) throws SQLException {
        String sql = "SELECT * FROM produto WHERE nome LIKE (?)";

        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ModelItemVenda> produtos = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + item.getNomeProduto() + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                if (produtos == null) {
                    produtos = new ArrayList<>();
                }
                ModelItemVenda itemProd = new ModelItemVenda();
                itemProd.setIdProduto(rs.getInt("cod_prod"));
                itemProd.setNomeProduto(rs.getString("nome"));
                itemProd.setQtdItens(rs.getInt("quantidade"));
                itemProd.setValorTotal(rs.getFloat("valor"));
                produtos.add(itemProd);
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
        return produtos;
    }

    public int getMaxIdVenda() throws SQLException {
        String sql = "SELECT MAX(idVenda) idVenda FROM venda";

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
            Logger.getLogger(DAOItemVenda.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void insert(ModelItemVenda item) throws SQLException {
        String sql = "INSERT INTO itemvenda(idVenda, idProduto, nomeProduto, qtdItens, valorTotal) "
                + "VALUES(?,?,?,?,?)";
        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, item.getIdVenda());
            stmt.setInt(2, item.getIdProduto());
            stmt.setString(3, item.getNomeProduto());
            stmt.setInt(4, item.getQtdItens());
            stmt.setFloat(5, item.getValorTotal());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DAOItemVenda.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
    }
    
    public void updateProduto(ModelItemVenda produto, int quantidade) throws SQLException{
        String sql = "UPDATE produto SET quantidade = ? WHERE nome = ?";
        
        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, quantidade);
            stmt.setString(2, produto.getNomeProduto());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOItemVenda.class.getName()).log(Level.SEVERE, null, ex);
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
