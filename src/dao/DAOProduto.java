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
import model.ModelProduto;

/**
 *
 * @author joao
 */
public class DAOProduto {
    private final Connection con;

    public DAOProduto(Connection con) {
        this.con = con;
    }
    
    public void insert(ModelProduto produto) throws SQLException{
        String sql = "insert into produto(nome,quantidade,custo,valor) values(?,?,?,?)";
        
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, produto.getNome());
        stmt.setInt(2, produto.getQuantidade());
        stmt.setFloat(3, produto.getCusto());
        stmt.setFloat(4, produto.getValor());
        stmt.execute();
        con.close();
    }
    
    public List<ModelProduto> consultaProduto() throws SQLException{
        String sql = "select * from produto";
        
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.execute();
        ResultSet rs = stmt.getResultSet();
        
        List<ModelProduto> produtos = new ArrayList<>();
        
        while(rs.next()){
            ModelProduto produto = new ModelProduto();
            
            produto.setId(rs.getInt("cod_prod"));
            produto.setNome(rs.getString("nome"));
            produto.setQuantidade(rs.getInt("quantidade"));
            produto.setCusto(rs.getFloat("custo"));
            produto.setValor(rs.getFloat("valor"));
            produtos.add(produto);
        }
        con.close();
        return produtos;
    }
    
    public List<ModelProduto> consultaProduto(ModelProduto produto) throws SQLException{
        String sql = "select * from produto where nome = ?";
        
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, produto.getNome());
        stmt.execute();
        ResultSet rs = stmt.getResultSet();
        
        List<ModelProduto> produtos = new ArrayList<>();
        
        while(rs.next()){
            produto.setId(rs.getInt("cod_prod"));
            produto.setNome(rs.getString("nome"));
            produto.setQuantidade(rs.getInt("quantidade"));
            produto.setCusto(rs.getFloat("custo"));
            produto.setValor(rs.getFloat("valor"));
            produtos.add(produto);
        }
        con.close();
        return produtos;
    }
}
