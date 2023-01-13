/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
public class Conexion {
    
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/sistemaventa?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER="root";
    private static final String PASSWORD="";
    
   
    public static java.sql.Connection getConnection() throws SQLException{
    
        return DriverManager.getConnection(JDBC_URL,USER,PASSWORD);
        
    }
    
    public static void close(ResultSet rs) throws SQLException{
    rs.close();
    }
    
    public static void close(PreparedStatement smtm) throws SQLException{
    smtm.close();
    }
    
    public static void close(java.sql.Connection con) throws SQLException{
    con.close();
    }
    
}
