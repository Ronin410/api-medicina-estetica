/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.citas.controller;

import com.api.citas.dto.Inventario;
import com.api.citas.entities.Respuesta;
import com.api.citas.service.InventarioService;
import com.api.citas.util.JwtUtil;
import com.api.citas.util.Meta;
import com.api.citas.util.Utils;
import jakarta.servlet.http.HttpServletRequest;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author alejandro.bueno
 */
@RestController
@RequestMapping("/inventario")
public class InventarioController {
    
    @Autowired
    InventarioService inventarioService;
    
    @Autowired
    Utils utils;
        
    private final Meta metaOk = new Meta(UUID.randomUUID().toString(), "OK", 200);

    
    @CrossOrigin(origins = "*")
    @GetMapping("/consultar/todo")
    public Respuesta ConsultarInventario(HttpServletRequest request){
            String token = request.getHeader("Authorization");
        
        if(token != null){
            if(JwtUtil.validateToken(token.substring("Bearer ".length()))){
                return new Respuesta(metaOk,inventarioService.ConsultarInventario());
            }else{
                return new Respuesta(metaOk,"El token no es valido");
            }
        }else{
            return new Respuesta(metaOk,"Necesita un token de sesion");
        }
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping("/agregar")
    public Respuesta AgregarInventario(HttpServletRequest request,
            @RequestBody Inventario inventario){
        
        String token = request.getHeader("Authorization");
        
        if(token != null){
            if(JwtUtil.validateToken(token.substring("Bearer ".length()))){
                return new Respuesta(metaOk,inventarioService.AgregarInventario(inventario));
            }else{
                return new Respuesta(metaOk,"El token no es valido");
            }
        }else{
            return new Respuesta(metaOk,"Necesita un token de sesion");
        }
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping("/modificar")
    public Respuesta ModificarInventario(HttpServletRequest request,
            @RequestBody Inventario inventario){
        
        String token = request.getHeader("Authorization");
        
        if(token != null){
            if(JwtUtil.validateToken(token.substring("Bearer ".length()))){
                return new Respuesta(metaOk,inventarioService.ModificarInventario(inventario));
            }else{
                return new Respuesta(metaOk,"El token no es valido");
            }
        }else{
            return new Respuesta(metaOk,"Necesita un token de sesion");
        }
    }
   
    @CrossOrigin(origins = "*")
    @PostMapping("/eliminar")
    public Respuesta EliminarInventario(HttpServletRequest request,
            @RequestParam(defaultValue = "0", name = "id") int id){
        
        String token = request.getHeader("Authorization");
        
        if(token != null){
            if(JwtUtil.validateToken(token.substring("Bearer ".length()))){
                return new Respuesta(metaOk,inventarioService.EliminarInventario(id));
            }else{
                return new Respuesta(metaOk,"El token no es valido");
            }
        }else{
            return new Respuesta(metaOk,"Necesita un token de sesion");
        }
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/ultimo")
    public Respuesta UltimoIdInventario(HttpServletRequest request){
        
        String token = request.getHeader("Authorization");
        
        if(token != null){
            if(JwtUtil.validateToken(token.substring("Bearer ".length()))){
                return new Respuesta(metaOk, inventarioService.Ultimo());
            }else{
                return new Respuesta(metaOk,"El token no es valido");
            }
        }else{
            return new Respuesta(metaOk,"Necesita un token de sesion");
        }
    }
}
