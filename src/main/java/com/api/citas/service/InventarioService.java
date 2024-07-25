/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.citas.service;

import com.api.citas.dto.Inventario;
import com.api.citas.repository.InventarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alejandro.bueno
 */
@Service
public class InventarioService {
    @Autowired
    InventarioRepository inventarioRepository;
    
    public List<Inventario> ConsultarInventario(){
        List<Inventario> inventario = inventarioRepository.findAll();

        return inventario;
    }

    public boolean AgregarInventario(Inventario inventario) {
        inventarioRepository.insert(inventario);
        return true;
    }

    public boolean ModificarInventario(Inventario inventario){
        Inventario Inventariobd;
        
        try{
            Inventariobd = ConsultarIdInventario(inventario.getIdProc());
            
            Inventariobd.setNomProc(inventario.getNomProc());
            Inventariobd.setPrecio(inventario.getPrecio());
            Inventariobd.setCantidad(inventario.getCantidad());
                       
            inventarioRepository.save(Inventariobd);

        }catch(Exception e){
            return false;
        }
        return true;
    }  
    
    

    public boolean EliminarInventario(int id) {
        inventarioRepository.deleteByIdProc(id);
        return true;
    }
    
    public Inventario ConsultarIdInventario(int idInventario){
        
        return inventarioRepository.findByIdProc(idInventario);

    }
    
    public int Ultimo(){
    
        Inventario inventario = inventarioRepository.findTopByOrderByIdProcDesc();
        if (inventario == null){
            return 0;
        }
        return inventario.getIdProc();
    }
    
}
