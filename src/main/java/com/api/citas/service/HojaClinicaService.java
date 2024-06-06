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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
        
        hojaClinicaRepository.deleteByIdCita(hojaClinica.getIdCita());
        
        hojaClinica.setCliente(hojaClinica.getCliente().toUpperCase());
        hojaClinica.setDoctora(hojaClinica.getDoctora().toUpperCase());      
        hojaClinicaRepository.insert(hojaClinica);
        return true;
    }

    public Object GenerarPdf(int id) throws FileNotFoundException, DocumentException, IOException {
       boolean pdfCreado = false;
        HojaClinica hojaClinica = null;
        
        try{
          hojaClinica = ConsultarHojaClinica(id);
        
        Document document = new Document();//PdfWriter.pages.A4
        PdfWriter.getInstance(document, new FileOutputStream("hoja_clinica.pdf"));
                
        String fontPath = "/path/to/Arial.ttf"; // Replace with the actual font file path
        BaseFont font = BaseFont.createFont(fontPath, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);
        Font tituloFont = new Font(font, 16, Font.BOLD);

        document.open();

        Paragraph titulo = new Paragraph("Hoja Clínica", tituloFont);
        document.add(titulo);

        Paragraph paciente = new Paragraph("Paciente: " + hojaClinica.getCliente(), tituloFont);
        document.add(paciente);

        Paragraph fechaNacimiento = new Paragraph("Fecha de Nacimiento: " + hojaClinica.getFechaNacimiento(), tituloFont);
        document.add(fechaNacimiento);

        Paragraph doctora = new Paragraph("Doctora: " + hojaClinica.getDoctora(), tituloFont);
        document.add(doctora);

        Paragraph fechaAtencion = new Paragraph("Fecha de Atención: " + hojaClinica.getFechaAtencion(), tituloFont);
        document.add(fechaAtencion);

        Paragraph resumen = new Paragraph("Resumen: " + hojaClinica.getResumen(), tituloFont);
        document.add(resumen);

        Paragraph tratamiento = new Paragraph("Tratamiento: " + hojaClinica.getTratamiento(), tituloFont);
        document.add(tratamiento);

        Paragraph observaciones = new Paragraph("Observaciones: " + hojaClinica.getObservaciones(), tituloFont);
        document.add(observaciones);

        document.close();
        }catch(Exception ex){
            return false;
        }
      
        return true;
    }


}
