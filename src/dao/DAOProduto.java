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
import model.ModelProduto;

/**
 *
 * @author joao
 */
public class DAOProduto {

    public void insert(ModelProduto produto) throws SQLException {
        String sql = "INSERT INTO produto(nome,quantidade,custo,valor) VALUES(?,?,?,?)";
        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setInt(2, produto.getQuantidade());
            stmt.setFloat(3, produto.getCusto());
            stmt.setFloat(4, produto.getValor());
            stmt.execute();
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

    public List<ModelProduto> consultaProduto() throws SQLException {
        String sql = "SELECT * FROM produto";

        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ModelProduto> produtos = null;

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                if (produtos == null) {
                    produtos = new ArrayList<>();
                }
                ModelProduto produto = new ModelProduto();
                produto.setId(rs.getInt("cod_prod"));
                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setCusto(rs.getFloat("custo"));
                produto.setValor(rs.getFloat("valor"));
                produtos.add(produto);
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
        return produtos;
    }

    public List<ModelProduto> procurar(ModelProduto produto) throws SQLException {
        String sql = "SELECT * FROM produto WHERE nome LIKE (?)";

        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ModelProduto> produtos = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + produto.getNome() + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                if (produtos == null) {
                    produtos = new ArrayList<>();
                }
                ModelProduto prod = new ModelProduto();
                prod.setId(rs.getInt("cod_prod"));
                prod.setNome(rs.getString("nome"));
                prod.setQuantidade(rs.getInt("quantidade"));
                prod.setCusto(rs.getFloat("custo"));
                prod.setValor(rs.getFloat("valor"));
                produtos.add(prod);
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
        return produtos;
    }
    
    public void removeProduto(ModelProduto produto) throws SQLException{
        String sql = "DELETE FROM produto  WHERE cod_prod = ?";
        
        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, produto.getId());
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
    
    public void updateProduto(ModelProduto produto) throws SQLException{
        String sql = "UPDATE produto SET nome = ?, "
                + "custo = ?, valor = ? WHERE cod_prod = ?;";
        
        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setFloat(2, produto.getCusto());
            stmt.setFloat(3, produto.getValor());
            stmt.setInt(4, produto.getId());
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
    
    public boolean verificaProduto(ModelProduto produto) throws SQLException  {
        String sql = "SELECT * FROM produto WHERE nome LIKE ?";

        Connection con = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                return true;
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
        return false;
    }
}
