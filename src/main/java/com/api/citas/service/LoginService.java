/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.citas.service;

import com.api.citas.dto.User;
import com.api.citas.entities.Credenciales;
import com.api.citas.repository.UserRepository;
import com.api.citas.util.JwtUtil;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 *
 * @author alejandro.bueno
 */
@Service
public class LoginService {
     
    @Autowired
    UserRepository userRepository;
    
    public String login(Credenciales credenciales){
        String token = "";
        if(ValidarCredenciales(credenciales.getUsuario(),credenciales.getPass())){//Iria validacion para ver si son correctas las credenciales
            token = JwtUtil.generateToken(credenciales.getUsuario());
        }else{
            return "Credenciales invalidas";
        }
        return token;
    }
    
    public boolean ValidarCredenciales(String usuario, String pass){
        boolean res = false;
        try{
            User users = userRepository.findByUserAndPass(usuario, pass);
            
            if(users.getIduser() != 0){
                res = true;
            }
        }catch(Exception ex){
            return false;
        }
        return res;
    }
    
    public boolean ValidarToken(String token){
        boolean res = false;
        try{
            res = JwtUtil.validateToken(token);

        }catch(Exception ex){
            return false;
        }
        return res;
    }
    
}
