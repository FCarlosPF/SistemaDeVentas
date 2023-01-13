/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class LoginDAO {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    public String login(String correo, String pass){
    
    String busquedaUsuario=null;
    String sql="Select correo,pass from usuarios where correo='"+correo+"'&& pass='"+pass+"'";
    
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()){
            busquedaUsuario= "Usuario Encontrado";
            }else{
            busquedaUsuario="Usuario No Encontrado";
            }
            
        } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
        }
    
    return busquedaUsuario;
    }
    
    
    public String buscarNombre(String correo){
    String busquedaNombre= null;
    String sql = "Select nombre from usuarios where correo='"+correo+"'";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            if(rs.next()){
            String nombre = rs.getString("nombre");
            busquedaNombre = nombre;
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            
        }
    
    
    return busquedaNombre;
    }
    
}
