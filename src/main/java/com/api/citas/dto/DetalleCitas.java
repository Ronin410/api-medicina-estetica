package com.api.citas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author alejandro.bueno
 */
@Document(collection = "ctl_citas_detalles")
@JsonIgnoreProperties("_class")
public class DetalleCitas {
 
    @Id
    @Getter
    @Setter
    private ObjectId id;
    
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
    
    @Getter
    @Setter
    private int cantidad;

    public DetalleCitas(ObjectId id, int idCita, int numProd, String nomProd, float precio, int cantidad) {
        this.id = id;
        this.idCita = idCita;
        this.numProd = numProd;
        this.nomProd = nomProd;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    

}