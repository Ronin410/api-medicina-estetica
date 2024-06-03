/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.citas.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author alejandro.bueno
 */
@Document(collection = "ctl_usuarios")
@JsonIgnoreProperties("_class")
public class User {
     @Getter
    @Setter
    private int iduser;
    
    @Getter
    @Setter
    private String pass;
    
    @Getter
    @Setter
    private String user;

    public User(int iduser, String pass, String user) {
        this.iduser = iduser;
        this.pass = pass;
        this.user = user;
    }

}
