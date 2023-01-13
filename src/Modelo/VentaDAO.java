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

/**
 *
 * @author LENOVO
 */
public class VentaDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public int idVenta(){
    int id =0;
    String sql = "Select MAX(id) from ventas";
    
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
            id=rs.getInt(1);
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
         return id;
    }
    
    
    
    public void registrarVenta(Venta v){
        try {
            String sql = "Insert into ventas(cliente,vendedor,total,fecha) values (?,?,?,?)";
            
            con= cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, v.getCliente());
            ps.setString(2, v.getVendedor());
            ps.setDouble(3, v.getTotal());
            ps.setString(4,v.getFecha());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                cn.close(con);
                cn.close(ps);
            } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            }
        }
    
    }
    
    public void registrarDetalle(Detalle detalle){
    
        String sql = "Insert into detalle(cod_pro,cantidad,precio,id_venta) values (?,?,?,?)";
        try {
            con= cn.getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1,detalle.getCod_pro());
            ps.setInt(2,detalle.getCantidad());
            ps.setDouble(3,detalle.getPrecio());
            ps.setInt(4,detalle.getId_venta());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                cn.close(con);
                cn.close(ps);   
            } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            }
        }
            
        
    }
    
    public boolean actualizarStock(int cantidad,String cod){
        
        String sql = "Update productos set stock=? where codigo =?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cantidad);
            ps.setString(2, cod);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                cn.close(con);
                cn.close(ps);
            } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            }
        }
        return false;
    }
    
    public List<Venta> listarVentas(){
        
    List<Venta> listaventa = new ArrayList<>();
    Venta venta;
    String sql = "Select * from ventas";
    
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
            int id=rs.getInt(1);
            String cliente=rs.getString(2);
            String vendedor=rs.getString(3);            
            Double total =rs.getDouble(4);
            String fecha = rs.getString(5);
            venta = new Venta(id,cliente,vendedor,total,fecha);
            listaventa.add(venta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    
    
        return listaventa;
     }
    
}
