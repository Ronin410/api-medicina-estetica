/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.citas.controller;

import com.api.citas.dto.Citas;
import com.api.citas.dto.HojaClinica;
import com.api.citas.entities.Respuesta;
import com.api.citas.service.HojaClinicaService;
import com.api.citas.util.JwtUtil;
import com.api.citas.util.Meta;
import com.itextpdf.text.DocumentException;
import jakarta.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alejandro.bueno
 */
@RestController
@RequestMapping("/hojaclinica")
public class HojaClinicaController {
    
    @Autowired
    HojaClinicaService hojaClinicaService;
        
    private final Meta metaOk = new Meta(UUID.randomUUID().toString(), "OK", 200);

    @CrossOrigin(origins = "*")
    @GetMapping("/consultar")
    public Respuesta ConsultarCitas(HttpServletRequest request, @RequestParam(defaultValue = "0", name = "id") int id){
            String token = request.getHeader("Authorization");
        
        if(token != null){
            if(JwtUtil.validateToken(token.substring("Bearer ".length()))){
                return new Respuesta(metaOk,hojaClinicaService.ConsultarHojaClinica(id));
            }else{
                return new Respuesta(metaOk,"El token no es valido");
            }
        }else{
            return new Respuesta(metaOk,"Necesita un token de sesion");
        }
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping("/agregar")
    public Respuesta AgregarCita(HttpServletRequest request,
            @RequestBody HojaClinica hojaClinica){
        
        String token = request.getHeader("Authorization");
        
        if(token != null){
            if(JwtUtil.validateToken(token.substring("Bearer ".length()))){
                return new Respuesta(metaOk,hojaClinicaService.AgregarHojaClinica(hojaClinica));
            }else{
                return new Respuesta(metaOk,"El token no es valido");
            }
        }else{
            return new Respuesta(metaOk,"Necesita un token de sesion");
        }
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/generar-pdf")
    public Respuesta GenerarPdf(HttpServletRequest request, @RequestParam(defaultValue = "0", name = "id") int id) throws DocumentException, IOException, FileNotFoundException, FileNotFoundException{
            String token = request.getHeader("Authorization");
        
        if(token != null){
            //if(JwtUtil.validateToken(token.substring("Bearer ".length()))){
                try {
                    return new Respuesta(metaOk, hojaClinicaService.GenerarPdf(id));
                } catch (JRException ex) {
                    Logger.getLogger(HojaClinicaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                return new Respuesta(metaOk,"");
            /*}else{
                return new Respuesta(metaOk,"El token no es valido");
            }*/
        }else{
            return new Respuesta(metaOk,"Necesita un token de sesion");
        }
    }
}