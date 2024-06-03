/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.citas.controller;

import com.api.citas.entities.Credenciales;
import com.api.citas.entities.Respuesta;
import com.api.citas.service.LoginService;
import com.api.citas.util.JwtUtil;
import com.api.citas.util.Meta;
import jakarta.servlet.http.HttpServletRequest;
import java.util.UUID;
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
@RequestMapping("/auth")
public class LoginController {
    
    private final Meta metaOk = new Meta(UUID.randomUUID().toString(), "OK", 200);
    
    @Autowired
    LoginService loginService;
   
    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public Respuesta login(HttpServletRequest request, @RequestBody Credenciales credenciales) {       
        return new Respuesta(metaOk,loginService.login(credenciales));
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/valida/token")
    public Respuesta validarToken(HttpServletRequest request, @RequestParam(defaultValue = "", name = "token") String token) {       
        return new Respuesta(metaOk,loginService.ValidarToken(token));
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/validar/token")
    public Respuesta validaToken(HttpServletRequest request/*, @RequestParam(defaultValue = "", name = "token") String token*/) {       
        return new Respuesta(metaOk,loginService.ValidarToken("fdfgd"));
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping("/token")
    public Respuesta token(HttpServletRequest request, @RequestBody Credenciales credenciales) {       
        return new Respuesta(metaOk,loginService.login(credenciales));
    }

}
