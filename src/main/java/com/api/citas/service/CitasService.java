package com.api.citas.service;

import com.api.citas.dto.Citas;
import com.api.citas.repository.CitasRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alejandro.bueno
 */
@Service
public class CitasService {
    
    @Autowired
    CitasRepository citasRepository;
        
    @Autowired 
    CitasDetallesService citasDetallesService;
    
    public List<Citas> ConsultarCitas(){
        List<Citas> citas = null;
        try{
         citas   = citasRepository.findAll();
        }catch(Exception ex){
            System.out.print("Error al consultar las citas");
        }

        return citas;
    }
    
    public List<Citas> ConsultarCita(int id, String nombre, String fecha){
         List<Citas> citas = null;
        LocalDateTime fechaFormateada= null;
        LocalDateTime fechaSiguiente = null;
        try{
            if(id > 0 && nombre.length() > 0 && fecha.length()>0){
                fechaFormateada = FormatearFecha(fecha);
                fechaSiguiente = fechaFormateada.withDayOfYear(fechaFormateada.getDayOfYear()+1);
                citas = citasRepository.findByClienteContainingAndIdCitaAndFechaBetween(nombre, id,fechaFormateada,fechaSiguiente);
            } else if(id > 0 &&  fecha.length()>0 ){
                fechaFormateada = FormatearFecha(fecha);
                fechaSiguiente = fechaFormateada.withDayOfYear(fechaFormateada.getDayOfYear()+1);
                citas = citasRepository.findByIdCitaAndFechaBetween(id,fechaFormateada,fechaSiguiente);
            } else if(nombre.length() > 0 &&  fecha.length()>0 ){
                fechaFormateada = FormatearFecha(fecha);
                fechaSiguiente = fechaFormateada.withDayOfYear(fechaFormateada.getDayOfYear()+1);
                citas = citasRepository.findByClienteContainingAndFechaBetween(nombre,fechaFormateada,fechaSiguiente);
            }else if(id > 0 && nombre.length() > 0 ){
                citas = citasRepository.findByClienteContainingAndIdCita(nombre, id);
            }else if(id > 0){
                citas = (List<Citas>) citasRepository.findByIdCita(id);
            }else if(nombre.length() > 0){
                citas = citasRepository.findByClienteContaining(nombre);
            }else if( fecha.length()>0){
                fechaFormateada = FormatearFecha(fecha);
                fechaSiguiente = fechaFormateada.withDayOfYear(fechaFormateada.getDayOfYear()+1);
                citas = citasRepository.findByFechaBetween(fechaFormateada,fechaSiguiente);
            } else{
                citas = citasRepository.findAll();
            }
        }catch(Exception ex){
            return citas;
        }
        return citas;
    }

    public boolean AgregarCita(Citas cita){  
        cita.setCliente(cita.getCliente().toUpperCase());
        citasRepository.insert(cita);
        return true;
    } 
    
    public boolean ModificarCita(Citas cita){
        
        try{
            citasRepository.deleteByIdCita(cita.getIdCita());
            AgregarCita(cita);
        }catch(Exception e){
            return false;
        }
        return true;
    }  
    
    public boolean EliminarCita(int id){
        
        citasRepository.deleteByIdCita(id);
        citasDetallesService.EliminarTodoDetalleCita(id);
        return true;
    }
    
    public int Ultimo(){
    
        Citas cita = citasRepository.findTopByOrderByIdCitaDesc();
        if (cita == null){
            return 0;
        }
        return cita.getIdCita();
    }
    
    public List<Citas> ConsultarFecha( String fecha){
        List<Citas> citas = null;
        try{
            LocalDateTime fechaConvertida = FormatearFecha(fecha);
            LocalDateTime fechaSiguiente = fechaConvertida.withDayOfYear(fechaConvertida.getDayOfYear()+1);
            citas = citasRepository.findByFechaBetween(fechaConvertida,fechaSiguiente);
            return citas;
        }catch(Exception ex){
            return citas;
        }
       
    }
    
    public LocalDateTime FormatearFecha(String fecha){
        fecha = fecha.replace(" ", "+");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"); // Handle optional digits after milliseconds
        LocalDateTime fechaConvertida = LocalDateTime.parse(fecha, formatter);
        fechaConvertida = fechaConvertida.withHour(0).withMinute(0).withSecond(0).withNano(0);

        return fechaConvertida;
    }

}