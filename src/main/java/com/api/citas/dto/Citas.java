package com.api.citas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Document(collection = "ctl_citas")
@JsonIgnoreProperties("_class")
public class Citas{

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
    private LocalDateTime fecha;
    
    @Getter
    @Setter
    private int status;
    
    @Getter
    @Setter
    private int total;

    public Citas(ObjectId id, int idCita, String cliente, String doctora, LocalDateTime fecha, int status, int total) {
        this.id = id;
        this.idCita = idCita;
        this.cliente = cliente;
        this.doctora = doctora;
        this.fecha = fecha;
        this.status = status;
        this.total = total;
    }
}
