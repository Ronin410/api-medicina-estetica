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
@Document(collection = "ctl_inventario")
@JsonIgnoreProperties("_class")
public class Inventario {
    
    @Id
    @Getter
    @Setter
    private ObjectId id;
        
    @Getter
    @Setter
    private int idProc;
    
    @Getter
    @Setter
    private String nomProc;
    
    @Getter
    @Setter
    private float precio;
    
    @Getter
    @Setter
    private int cantidad;

    public Inventario(ObjectId id, int idProc, String nomProc, float precio, int cantidad) {
        this.id = id;
        this.idProc = idProc;
        this.nomProc = nomProc;
        this.precio = precio;
        this.cantidad = cantidad;
    }
}
