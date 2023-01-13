/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ReportePdf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
interface Reporte {
        public abstract void generarReporte(String DES, String titulo) throws SQLException, FileNotFoundException, IOException;

}
