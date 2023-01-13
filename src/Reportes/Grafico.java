/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reportes;

import Modelo.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author LENOVO
 */
public class Grafico {
    
    public static void Graficar (String fecha){
    
        Connection con;
        Conexion cn = new Conexion();
        PreparedStatement ps;
        ResultSet rs;
        
        String sql = "Select total from ventas";
        
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            DefaultPieDataset dataset = new DefaultPieDataset();
            while(rs.next()){
            dataset.setValue(rs.getString("total"), rs.getDouble("total"));
            }
            JFreeChart jf = ChartFactory.createPieChart("reporte de venta", dataset);
            ChartFrame f = new ChartFrame("Total de venta por dia", jf);
            f.setSize(1000,500);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
        
    }
    
}
