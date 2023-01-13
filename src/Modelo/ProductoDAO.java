/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author LENOVO
 */
public class ProductoDAO {
    
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    
    public boolean registrarProducto(Producto producto){
        
        String sql = "Insert into productos(codigo,nombre,proveedor,stock,precio) values (?,?,?,?,?)";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,producto.getCodigo());
            ps.setString(2,producto.getNombre());
            ps.setString(3,producto.getProveedor());
            ps.setInt(4,producto.getStock());
            ps.setDouble(5,producto.getPrecio());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
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
    
    public void consultarProveedor(JComboBox proveedor){
        String sql = "Select nombre from proveedor";
        try {
            con= cn.getConnection();
            ps= con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
            proveedor.addItem(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public List<Producto> listarProducto(){
    
    List<Producto> productos = new ArrayList<>();
    Producto producto;
    String sql = "Select * from productos";
        try {
            con = cn.getConnection();
            ps= con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
            int id = rs.getInt(1);
            String codigo = rs.getString(2);
            String nombre = rs.getString(3);
            String proveedor = rs.getString(4);
            int stock = rs.getInt(5);
            Double precio = rs.getDouble(6);
            producto = new Producto(id,codigo,nombre,proveedor,stock,precio);
            productos.add(producto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
            return productos;

    }
    
    public void eliminarProducto(int id){
        String sql = "Delete from productos where id=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
    
    public void editarProducto(Producto producto){
    
        String sql = "Update productos set codigo=?, nombre=?,proveedor=?,stock=?,precio=? where id=?";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setString(3, producto.getProveedor());
            ps.setInt(4, producto.getStock());
            ps.setDouble(5, producto.getPrecio());
            ps.setInt(6, producto.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
    
    public Producto buscarProducto(String cod){
    
    Producto producto = new Producto();
    String sql ="Select * from productos where codigo=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if(rs.next()){
            producto.setNombre(rs.getString("nombre"));
            producto.setPrecio(rs.getDouble("precio"));
            producto.setStock(rs.getInt("stock"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
                return producto;

    }
    
    public Configuracion Config(){
    
    Configuracion configuracion = new Configuracion();
    String sql ="Select * from config";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
            configuracion.setId(rs.getInt(1));
            configuracion.setNombre(rs.getString(2));
            configuracion.setRuc(rs.getString(3));
            configuracion.setTelefono(rs.getInt(4));
            configuracion.setDireccion(rs.getString(5));
            configuracion.setRazon(rs.getString(6));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return configuracion;
    }
    
    public void modificarDatos(Configuracion configuracion){
    
        String sql = "Update config set nombre=?, ruc=?,telefono=?,direccion=?,razon=? where id=?";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, configuracion.getNombre());
            ps.setString(2, configuracion.getRuc());
            ps.setInt(3, configuracion.getTelefono());
            ps.setString(4, configuracion.getDireccion());
            ps.setString(5, configuracion.getRazon());
            ps.setInt(6, configuracion.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
}
