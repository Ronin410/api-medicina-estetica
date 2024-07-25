/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.citas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author alejandro.bueno
 */
@Document(collection = "ctl_hojas_clinicas")
@JsonIgnoreProperties("_class")
public class HojaClinica {
 
    @Id
    @Getter
    @Setter
    private ObjectId id;
        
    @Getter
    @Setter
    private int idCita;
    
    @Getter
    @Setter
    private String cliente;
    
    @Getter
    @Setter
    private String doctora;
    
    @Getter
    @Setter
    private LocalDate fechaAtencion;
    
    @Getter
    @Setter
    private LocalDate fechaNacimiento;
    
    @Getter
    @Setter
    private String antecedentes;
    
    @Getter
    @Setter
    private String resumen;
    
    @Getter
    @Setter
    private String tratamiento;
    
    @Getter
    @Setter
    private String observaciones;

    public HojaClinica(ObjectId id, int idCita, String cliente, String doctora, LocalDate fechaAtencion, LocalDate fechaNacimiento, String antecedentes, String resumen, String tratamiento, String observaciones) {
        this.id = id;
        this.idCita = idCita;
        this.cliente = cliente;
        this.doctora = doctora;
        this.fechaAtencion = fechaAtencion;
        this.fechaNacimiento = fechaNacimiento;
        this.antecedentes = antecedentes;
        this.resumen = resumen;
        this.tratamiento = tratamiento;
        this.observaciones = observaciones;
    }
    
    
}
