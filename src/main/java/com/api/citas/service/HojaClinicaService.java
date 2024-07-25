/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.citas.service;

import com.api.citas.dto.HojaClinica;
import com.api.citas.repository.HojaClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

//import com.itextpdf.layout.property.PageSize;
/**
 *
 * @author alejandro.bueno
 */
@Service
public class HojaClinicaService {
        
    @Autowired
    HojaClinicaRepository hojaClinicaRepository;
            
    public HojaClinica ConsultarHojaClinica(int id){
        HojaClinica hojaClinica = null;
        try{      
            hojaClinica = hojaClinicaRepository.findByIdCita(id);
        }catch(Exception ex){
            return hojaClinica;
        }
        return hojaClinica;
    }

    public Object AgregarHojaClinica(HojaClinica hojaClinica) {
        HojaClinica hojaClinicabd;
        //hojaClinicaRepository.deleteByIdCita(hojaClinica.getIdCita());
        hojaClinicabd = ConsultarHojaClinica(hojaClinica.getIdCita());
        //hojaClinica.setIdCita(hojaClinicabd.getIdCita());
        hojaClinica.setId(hojaClinicabd.getId());
        hojaClinica.setCliente(hojaClinica.getCliente().toUpperCase());
        hojaClinica.setDoctora(hojaClinica.getDoctora().toUpperCase());      
        hojaClinicaRepository.save(hojaClinica);
        return true;
    }

    public byte[] GenerarPdf(int id) throws FileNotFoundException, DocumentException, IOException, JRException {
   
        HojaClinica hojaConsultada;
        String fechaNacimiento;
        String fechaAtencion;
        //String filePath = "C:"+ File.separator + "Users"+ File.separator + "alejandro.bueno"+ File.separator + "Desktop"+ File.separator + "Medicinaestetica"+ File.separator + 
        //"Reportes"+ File.separator + "MyReports"+ File.separator + "Reporte1.jrxml";

        String filePath = "src"+ File.separator + "main"+ File.separator + "java"+ File.separator + "com"+ File.separator + "api"+ File.separator + 
        "reports"+ File.separator + "HojaClinica.jrxml";
        
        HashMap<String, Object> parametros = new HashMap<>();  
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        hojaConsultada = ConsultarHojaClinica(id);
                
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Ejemplo: formato ISO-8601
             
        parametros.put("antecedentes",hojaConsultada.getAntecedentes());
        parametros.put("resumen",hojaConsultada.getResumen());
        parametros.put("tratamiento",hojaConsultada.getTratamiento());
        parametros.put("observaciones",hojaConsultada.getObservaciones());
        parametros.put("nombrePaciente",hojaConsultada.getCliente());
        parametros.put("fechaNac",hojaConsultada.getFechaNacimiento().format(formatter));
        parametros.put("fechaConsulta",hojaConsultada.getFechaAtencion().format(formatter));

        try {
            JasperReport report = JasperCompileManager.compileReport(filePath);
            JasperPrint print = JasperFillManager.fillReport(report, parametros, new JREmptyDataSource());

            JasperExportManager.exportReportToPdfStream(print, baos);
      

        } catch (JRException e) {
            e.printStackTrace(); // Handle compilation errors (optional, but recommended)
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try {
                baos.close(); // Close the stream to ensure proper resource management
            } catch (IOException e) {
                e.printStackTrace(); // Handle potential I/O errors
            }
        }

        return baos.toByteArray();
    }

}


/*
public byte[] getItemReport(List<Item> items, String format) {
            JasperExportManager.exportReportToPdfFile(print, destinationPath);
            //ByteArrayOutputStream baos = new ByteArrayOutputStream();


	JasperReport jasperReport;

	try {

		jasperReport = (JasperReport) JRLoader.loadObject(ResourceUtils.getFile("item-report.jasper"));
	} catch (FileNotFoundException | JRException e) {
	try {

		  File file = ResourceUtils.getFile("classpath:item-report.jrxml");
		  jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		  JRSaver.saveObject(jasperReport, "item-report.jasper");
		} catch (FileNotFoundException | JRException ex) {
		  throw new RuntimeException(e);
		}
	}

	//...
}*/