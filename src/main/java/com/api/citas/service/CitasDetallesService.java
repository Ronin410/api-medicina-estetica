/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.citas.service;

import com.api.citas.dto.Citas;
import com.api.citas.dto.DetalleCitas;
import com.api.citas.dto.Inventario;
import com.api.citas.repository.CitasDetallesRepository;
import com.api.citas.repository.CitasRepository;
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
    CitasRepository citasRepository;
        
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
        Citas cita;
        Inventario procedimiento;
        int totalPagar = 500;
        
        int idProc = 0;
        try{
                        
            cita = citasRepository.findByIdCita(listDetalle.get(0).getIdCita());
                   
            detalle = ConsultarDetalleCita(listDetalle.get(0).getIdCita());

            for(int i = 0; i < detalle.size(); i++){

                procedimiento =  inventarioRepository.findByIdProc(detalle.get(i).getNumProd());
                if(detalle.size() > 0){
                    if(detalle.get(i).getCantidad() > 0){
                        procedimiento.setCantidad(procedimiento.getCantidad() + detalle.get(i).getCantidad());
                        //inventarioRepository.deleteByIdProc(procedimiento.getIdProc());
                        inventarioRepository.save(procedimiento);
                    }
                }
            }        

            EliminarTodoDetalleCita(listDetalle.get(0).getIdCita());

            for(int i = 0; i < listDetalle.size(); i++){

                if( listDetalle.get(i) != null){

                    int cantidad = listDetalle.get(i).getCantidad();
                    
                    if(cantidad > 0){
                        totalPagar = (int) (totalPagar + (listDetalle.get(i).getPrecio() * cantidad));

                        idProc = listDetalle.get(i).getNumProd();
                        procedimiento = inventarioRepository.findByIdProc(idProc);
                        
                        procedimiento.setCantidad(procedimiento.getCantidad() - listDetalle.get(i).getCantidad());
                        //inventarioRepository.deleteByIdProc(procedimiento.getIdProc()); 
                        inventarioRepository.save(procedimiento);
                        citasDetallesRepository.insert(listDetalle.get(i));

                        
                    }
                }
            }
            cita.setTotal(totalPagar);
            //citasRepository.deleteByIdCita(cita.getIdCita());
            citasRepository.save(cita);
            
        }catch(Exception ex){
            return false;
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
