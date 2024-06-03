package com.api.citas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author alejandro.bueno
 */
@Document(collection = "ctl_citas")
@JsonIgnoreProperties("_class")
public class Citas{

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
    
    

    public Citas(int idCita, String cliente, String doctora, LocalDateTime fecha, int status) {
        this.idCita = idCita;
        this.cliente = cliente;
        this.doctora = doctora;
        this.fecha = fecha;
        this.status = status;
    }
}
