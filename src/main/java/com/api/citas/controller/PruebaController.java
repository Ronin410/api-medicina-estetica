/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.citas.controller;

import com.api.citas.entities.Credenciales;
import com.api.citas.entities.Respuesta;
import com.api.citas.service.PruebaService;
import com.api.citas.util.Meta;
import jakarta.servlet.http.HttpServletRequest;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alejandro.bueno
 */
@RestController
public class PruebaController {
        private final Meta metaOk = new Meta(UUID.randomUUID().toString(), "OK", 200);

    @Autowired
    PruebaService pruebaService;
        
    @CrossOrigin(origins = "*")
    @GetMapping("/prueba")
    public Respuesta prueba(HttpServletRequest request) {
        return new Respuesta(metaOk,pruebaService.agregar());
        
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/pruebac")
    public Respuesta consulta(HttpServletRequest request) {
        return new Respuesta(metaOk,pruebaService.consulta());
        
    }
}
