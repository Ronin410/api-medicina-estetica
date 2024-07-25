/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.citas.service;

import com.api.citas.dto.prueba;
import com.api.citas.repository.PruebaRepository;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alejandro.bueno
 */
@Service
public class PruebaService {
    @Autowired
    PruebaRepository pruebaRepository;
    
    public boolean agregar( ){
       
        
       ObjectId id = new ObjectId();
       prueba pruebax = new prueba(id,"",0);
       pruebaRepository.save(pruebax);
       return true;
    }
    
    public boolean consulta( ){
       
        List<prueba> pruebas = pruebaRepository.findAll();
        Optional<prueba> asa = pruebaRepository.findById(pruebas.get(0).getId());
        
        prueba aaa = pruebas.get(0);
        
        aaa.setName("Alejandro");
        
        pruebaRepository.save(aaa);
        
        
       return true;
    }
}
