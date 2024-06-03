package com.api.citas.controller;

import com.api.citas.dto.Citas;
import com.api.citas.dto.DetalleCitas;
import com.api.citas.entities.Respuesta;
import com.api.citas.service.CitasDetallesService;
import com.api.citas.service.CitasService;
import com.api.citas.util.JwtUtil;
import com.api.citas.util.Meta;
import com.api.citas.util.Utils;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/citas")
public class CitasController {
    
    @Autowired
    CitasService citasService;
    
    @Autowired
    CitasDetallesService citasDetalleService;
    
    @Autowired
    Utils utils;
        
    private final Meta metaOk = new Meta(UUID.randomUUID().toString(), "OK", 200);

    @CrossOrigin(origins = "*")
    @GetMapping("/consultar/todos")
    public Respuesta ConsultarCitas(HttpServletRequest request){
            String token = request.getHeader("Authorization");
        
        if(token != null){
            if(JwtUtil.validateToken(token.substring("Bearer ".length()))){
                return new Respuesta(metaOk,citasService.ConsultarCitas());
            }else{
                return new Respuesta(metaOk,"El token no es valido");
            }
        }else{
            return new Respuesta(metaOk,"Necesita un token de sesion");
        }
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/consultar/cita")
    public Respuesta ConsultarCita(HttpServletRequest request,
            @RequestParam(defaultValue = "0", name = "id") int id,
            @RequestParam(defaultValue = "", name = "nombre") String nombre,
            @RequestParam(defaultValue = "", name = "fecha") String fecha){
        
        String token = request.getHeader("Authorization");
        
        if(token != null){
            if(JwtUtil.validateToken(token.substring("Bearer ".length()))){
                return new Respuesta(metaOk,citasService.ConsultarCita(id, nombre, fecha));
            }else{
                return new Respuesta(metaOk,"El token no es valido");
            }
        }else{
            return new Respuesta(metaOk,"Necesita un token de sesion");
        }
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/consultar/detalle/cita")
    public Respuesta ConsultarCita(HttpServletRequest request,
            @RequestParam(defaultValue = "0", name = "id") int id){
        
        String token = request.getHeader("Authorization");
        
        if(token != null){
            if(JwtUtil.validateToken(token.substring("Bearer ".length()))){
                return new Respuesta(metaOk,citasDetalleService.ConsultarDetalleCita(id));
            }else{
                return new Respuesta(metaOk,"El token no es valido");
            }
        }else{
            return new Respuesta(metaOk,"Necesita un token de sesion");
        }
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/consultar/total")
    public Respuesta TotalPagar(HttpServletRequest request,
            @RequestParam(defaultValue = "0", name = "id") int id){
        
        String token = request.getHeader("Authorization");
        
        if(token != null){
            if(JwtUtil.validateToken(token.substring("Bearer ".length()))){
                return new Respuesta(metaOk,citasDetalleService.TotalCuenta(id));
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
            @RequestBody Citas cita){
        
        String token = request.getHeader("Authorization");
        
        if(token != null){
            if(JwtUtil.validateToken(token.substring("Bearer ".length()))){
                return new Respuesta(metaOk,citasService.AgregarCita(cita));
            }else{
                return new Respuesta(metaOk,"El token no es valido");
            }
        }else{
            return new Respuesta(metaOk,"Necesita un token de sesion");
        }
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping("/agregar/detalle")
    public Respuesta AgregarDetalleCita(HttpServletRequest request,
            @RequestBody List<DetalleCitas> listDetalle){
        
        String token = request.getHeader("Authorization");
        
        if(token != null){
            if(JwtUtil.validateToken(token.substring("Bearer ".length()))){
                return new Respuesta(metaOk,citasDetalleService.AgregarDetalleCita(listDetalle));
            }else{
                return new Respuesta(metaOk,"El token no es valido");
            }
        }else{
            return new Respuesta(metaOk,"Necesita un token de sesion");
        }
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping("/modificar")
    public Respuesta ModificarCita(HttpServletRequest request,
            @RequestBody Citas cita){
        
        String token = request.getHeader("Authorization");
        
        if(token != null){
            if(JwtUtil.validateToken(token.substring("Bearer ".length()))){
                return new Respuesta(metaOk,citasService.ModificarCita(cita));
            }else{
                return new Respuesta(metaOk,"El token no es valido");
            }
        }else{
            return new Respuesta(metaOk,"Necesita un token de sesion");
        }
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/eliminar")
    public Respuesta EliminarCita(HttpServletRequest request,
            @RequestParam(defaultValue = "0", name = "id") int id){
        
        String token = request.getHeader("Authorization");
        
        if(token != null){
            if(JwtUtil.validateToken(token.substring("Bearer ".length()))){
                return new Respuesta(metaOk,citasService.EliminarCita(id));
            }else{
                return new Respuesta(metaOk,"El token no es valido");
            }
        }else{
            return new Respuesta(metaOk,"Necesita un token de sesion");
        }
    }
    
    @CrossOrigin(origins = "*")
    @GetMapping("/eliminar/detalle/cita")
    public Respuesta EliminarDetalleCita(HttpServletRequest request,
            @RequestParam(defaultValue = "0", name = "id") int id,
            @RequestParam(defaultValue = "0", name = "numProd") int numProd){
        
        String token = request.getHeader("Authorization");
        
        if(token != null){
            if(JwtUtil.validateToken(token.substring("Bearer ".length()))){
                return new Respuesta(metaOk,citasDetalleService.EliminarDetalleCita(id, numProd));
            }else{
                return new Respuesta(metaOk,"El token no es valido");
            }
        }else{
            return new Respuesta(metaOk,"Necesita un token de sesion");
        }
    }    
    
    @CrossOrigin(origins = "*")
    @GetMapping("/ultimo")
    public Respuesta UltimoIdCita(HttpServletRequest request){
        
        String token = request.getHeader("Authorization");
        
        if(token != null){
            if(JwtUtil.validateToken(token.substring("Bearer ".length()))){
                return new Respuesta(metaOk,citasService.Ultimo());
            }else{
                return new Respuesta(metaOk,"El token no es valido");
            }
        }else{
            return new Respuesta(metaOk,"Necesita un token de sesion");
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/fecha")
    public Respuesta ConsultarFecha(HttpServletRequest request,@RequestParam String fecha){
     String token = request.getHeader("Authorization");
        if(token != null){
            if(JwtUtil.validateToken(token.substring("Bearer ".length()))){
               return new Respuesta(metaOk,citasService.ConsultarFecha(fecha));
            }else{
                return new Respuesta(metaOk,"El token no es valido");
            }
        }else{
            return new Respuesta(metaOk,"Necesita un token de sesion");
        }
    }    
}
