/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.citas.util;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Meta
 */
@AllArgsConstructor
@NoArgsConstructor
@Data public class Meta {

    private String transactionID;

    private String status;

    private int statusCode;

    private String timestamp;

    @JsonInclude(value = Include.NON_NULL)
    private String message;

    public Meta(String transactionID, String status, int statusCode) {
        this.transactionID = transactionID;
        this.status = status;
        this.statusCode = statusCode;
        this.timestamp = LocalDateTime.now().toString();
    }  

    public Meta metaError(){
        Meta meta = new Meta();
        
        meta.setTransactionID(null);
        meta.setStatus("CLIENT_ERROR");
        meta.setStatusCode(404);
        meta.setTimestamp("1900-01-01");
        meta.setMessage("Información no encontrada");

        return meta; 
    }
   
}
