/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class ProveedorDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    
    public boolean registrarProveedor(Proveedor prov){
  
    String sql = "Insert into proveedor(ruc,nombre,telefono,direccion,razon) values (?,?,?,?,?)";
    
        try {
            con =cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,prov.getRuc());
            ps.setString(2,prov.getNombre());
            ps.setInt(3,prov.getTelefono());
            ps.setString(4,prov.getDireccion());
            ps.setString(5,prov.getRazon());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            return false;
        } finally {
        try {
            cn.close(con);
            cn.close(ps);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        }
    
    
    }
    
    public List<Proveedor> listarProveedor(){
    
        String sql = "Select * from proveedor";
        Proveedor proveedor;
        List<Proveedor> proveedores = new ArrayList<>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
            int id =rs.getInt(1);
            int ruc=rs.getInt(2);
            String nombre=rs.getString(3);
            int telefono= rs.getInt(4);
            String direccion=rs.getString(5);
            String razon = rs.getString(6);
            proveedor = new Proveedor(id,ruc,nombre,telefono,direccion,razon);
            proveedores.add(proveedor);
            }
        } catch (Exception e) {
            
        } finally {
            try {
                cn.close(con);
                cn.close(ps);
                cn.close(rs);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        
        return proveedores;
    }
    
    
    public boolean eliminarProveedor(int id){
  
    String sql = "DELETE FROM proveedor where id=?";
    
        try {
            con =cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            return false;
        } finally {
        try {
            cn.close(con);
            cn.close(ps);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        }
    
    
    }
    public boolean editarProveedor(Proveedor prov){
  
    String sql = "Update proveedor set ruc=?,nombre=?,telefono=?,direccion=?,razon=? where id=?";
    
        try {
            con =cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,prov.getRuc());
            ps.setString(2,prov.getNombre());
            ps.setInt(3,prov.getTelefono());
            ps.setString(4,prov.getDireccion());
            ps.setString(5,prov.getRazon());
            ps.setInt(6,prov.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
            return false;
        } finally {
        try {
            cn.close(con);
            cn.close(ps);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        }
    
    
    }
}
