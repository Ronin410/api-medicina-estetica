/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.citas.service;

import com.api.citas.dto.DetalleCitas;
import com.api.citas.dto.Inventario;
import com.api.citas.repository.CitasDetallesRepository;
import com.api.citas.repository.InventarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alejandro.bueno
 */
@Service
public class CitasDetallesService {
    
    @Autowired
    CitasDetallesRepository citasDetallesRepository;
        
    @Autowired
    InventarioRepository inventarioRepository;
    
    public float TotalCuenta(int id){        
        List<DetalleCitas> detalle = citasDetallesRepository.findByIdCita(id);
        List<DetalleCitas> ds =  citasDetallesRepository.findAll();
        float totalPagar = 0;
        if(detalle.size() > 0){
            for(int i = 0 ; i < detalle.size(); i++){
                totalPagar = totalPagar + detalle.get(i).getPrecio();
            }
        }
        return totalPagar;
    } 
      
    public boolean AgregarDetalleCita(List<DetalleCitas> listDetalle){ 
       List<DetalleCitas> detalle;
        List<Inventario> inventario;
        Inventario procedimiento;
        detalle = ConsultarDetalleCita(listDetalle.get(0).getIdCita());
        
        
        inventario=inventarioRepository.findAll();
        //Actualizar inventario
        
       for(int i = 0; i < listDetalle.size(); i++){
            procedimiento = inventario.get(i);
            if(detalle.size() > 0){
                if(detalle.get(i).getCantidad() > 0){
                    procedimiento.setCantidad(procedimiento.getCantidad() + detalle.get(i).getCantidad());
                }
            }
            int as = listDetalle.get(i).getCantidad();
            if(as > 0){
                procedimiento.setCantidad(procedimiento.getCantidad() - listDetalle.get(i).getCantidad());
            }
            inventarioRepository.deleteByIdProc(inventario.get(i).getIdProc());
            inventarioRepository.save(inventario.get(i));
            
        }    
        
        EliminarTodoDetalleCita(listDetalle.get(0).getIdCita());

        for(int i = 0; i < listDetalle.size(); i++){
            citasDetallesRepository.insert(listDetalle.get(i));
        }

        return true;
    }     
    
    public List<DetalleCitas> ConsultarDetalleCita(int id){        
        List<DetalleCitas> detalleCitas = citasDetallesRepository.findByIdCita(id);
        return detalleCitas;
    } 
    
    public void EliminarTodoDetalleCita(int id){        
        citasDetallesRepository.deleteByIdCita(id);
    } 
    
    public boolean EliminarDetalleCita(int id, int numProd){        
        citasDetallesRepository.deleteByIdCitaAndNumProd(id, numProd);
        return true;
    }
}
