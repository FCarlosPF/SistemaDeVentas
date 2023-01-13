/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class ClienteDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public boolean RegistrarCliente(Cliente cl){
    String sql = "Insert into clientes(dni,nombre,telefono,direccion,razon) values (?,?,?,?,?)";
        try {
            con =cn.getConnection();
            ps= con.prepareStatement(sql);
            ps.setInt(1,cl.getDni());
            ps.setString(2,cl.getNombre());
            ps.setInt(3,cl.getTelefono());
            ps.setString(4,cl.getDireccion());
            ps.setString(5,cl.getRazon());    
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }finally{
        try {
            cn.close(con);
            cn.close(ps);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        }
    }
    
     public java.util.List<Cliente> listar(){
        String SQL_SELECT= "SELECT * FROM clientes";
        Cliente cl;
        List<Cliente> listaCl = new ArrayList<>();
        try {
            con = Conexion.getConnection();
            ps= con.prepareStatement(SQL_SELECT);
            rs=ps.executeQuery();
            while(rs.next()){
            int id=rs.getInt(1);
            int dni=rs.getInt(2);
            String nombre=rs.getString(3);
            int telefono=rs.getInt(4);
            String direccion=rs.getString(5);
            String razon= rs.getString(6);
            cl =new Cliente(id,dni,nombre,telefono,direccion,razon);
            listaCl.add(cl);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                Conexion.close(con);
                Conexion.close(ps);
                Conexion.close(rs);
            } catch (SQLException ex) {
                 ex.printStackTrace(System.out);
            }
        }
        return listaCl;
    }
    
      public boolean eliminar(int id){
    String SQL_DELETE= "DELETE FROM clientes WHERE id = ?";
        try {
            con = cn.getConnection();
            ps= con.prepareStatement(SQL_DELETE);
            ps.setInt(1,id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            return false;
        }finally{
            try {
                Conexion.close(con);
                Conexion.close(ps);
            } catch (SQLException ex) {
                 ex.printStackTrace(System.out);
            }
        }
    }
     
     public boolean ModificarCliente(Cliente cl){
     String sql = "Update clientes set dni=?,nombre=?,telefono=?,direccion=?,razon=? where id=?";
        try {
            con =cn.getConnection();
            ps= con.prepareStatement(sql);
            ps.setInt(1,cl.getDni());
            ps.setString(2,cl.getNombre());
            ps.setInt(3,cl.getTelefono());
            ps.setString(4,cl.getDireccion());
            ps.setString(5,cl.getRazon());    
            ps.setInt(6,cl.getId());    
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }finally{
        try {
            cn.close(con);
            cn.close(ps);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        }
    }
     
    public Cliente buscarCliente(int dni) {
            
     Cliente cl = new Cliente() ;
     String sql = "Select * from clientes where dni=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            rs = ps.executeQuery();
            if(rs.next()){
            cl.setNombre(rs.getString("nombre"));
            cl.setTelefono(rs.getInt("telefono"));
            cl.setDireccion(rs.getString("direccion"));
            cl.setRazon(rs.getString("razon"));
            
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
         try {
             cn.close(con);
             cn.close(ps);
             cn.close(rs);
         } catch (SQLException ex) {
            ex.printStackTrace(System.out);
         }
         
        }
        return cl;
}
}
    
