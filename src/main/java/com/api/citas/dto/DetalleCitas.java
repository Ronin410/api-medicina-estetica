package com.api.citas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author alejandro.bueno
 */
@Document(collection = "ctl_citas_detalles")
@JsonIgnoreProperties("_class")
public class DetalleCitas {
 
    @Getter
    @Setter
    private int idCita;
    
    @Getter
    @Setter
    private int numProd;
    
    @Getter
    @Setter
    private String nomProd;
    
    @Getter
    @Setter
    private float precio;

    public DetalleCitas(int idCita, int numProd, String nomProd, float precio) {
        this.idCita = idCita;
        this.numProd = numProd;
        this.nomProd = nomProd;
        this.precio = precio;
    }
}