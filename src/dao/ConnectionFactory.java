/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author joao
 */
public class ConnectionFactory {
    private final String URL = "jdbc:postgresql://localhost:5432/projeto";
    private final String USER = "postgres";
    private final String PASSWORD = "12345";
    
    public Connection getConnection() throws SQLException{
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        return con;
    }
    public static void closeConnection(Connection con) throws SQLException{
        con.close();
    }
    public static void closeConnection(Connection con, PreparedStatement stmt) throws SQLException{
        try (stmt) {
            closeConnection(con);
        }
    }
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) throws SQLException{
        try (rs) {
            closeConnection(con, stmt);
        }
    }
}
