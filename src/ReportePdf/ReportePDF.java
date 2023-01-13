/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReportePdf;

import Modelo.Conexion;
import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;

/**
 *
 * @author LENOVO
 */
public class ReportePDF implements Reporte {

    Conexion cn = new Conexion();
    Connection con;
    String sql ="Select cod_pro,cantidad,precio,id_venta from detalle";

    public void generarReporte(String DES, String titulo) throws SQLException, FileNotFoundException, IOException {
        
        PdfWriter writer = new PdfWriter(DES);
        
        PdfDocument pdf = new PdfDocument(writer);
        
        Document document = new Document(pdf, PageSize.A4.rotate());
        
        EventoPDF evento = new EventoPDF(document,titulo);
        
        pdf.addEventHandler(PdfDocumentEvent.END_PAGE,evento);
        
        document.setMargins(75,36,75,36);
        
        PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
        PdfFont bold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
        
        String tituloTabla[]= {"Codigo Producto","Cantidad","Precio","Id_venta"};
        
        float[] anchoColumn ={3,3,3,2};
        
        Table table = new Table(anchoColumn);
        
        table.setWidth(UnitValue.createPercentValue(100));
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
        con = cn.getConnection();
        ps =con.prepareStatement(sql);
        rs = ps.executeQuery();
        
        for(String encabezadoTabla : tituloTabla){
            process(table, encabezadoTabla,bold,true);
        }
        
        while(rs.next()){
        String line ="";
            for (int i = 1; i <= 4; i++) {
                String valor =rs.getString(i);
                if(i==4 ){
                if(valor==null || valor.trim().length() == 0  ){
                    line += "-"; 
                }else{
                    line +=valor;
                }
                }else{
                if(valor==null || valor.trim().length() == 0){
                line+="-;";
                }else{
                line+=valor+";";
                }
                }
            }
            process(table,line,font,false);
        }
        document.add(table);
        document.close();
        
        }catch (Exception e){
        
        }finally{
        cn.close(con);
        cn.close(ps);
        }
        
    }
    
    public void process(Table table, String line, PdfFont font, boolean isHeader){
    
        StringTokenizer tokenizer= new StringTokenizer(line,";");
        while(tokenizer.hasMoreTokens()){
        if(isHeader){
            table.addHeaderCell(new Cell().add(new Paragraph(tokenizer.nextToken()).setFont(font)));
            
        }else{
            table.addCell(new Cell().add(new Paragraph(tokenizer.nextToken()).setFont(font)));
        }
        }
    }
    
}
    
