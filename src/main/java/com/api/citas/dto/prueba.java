/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
@Document(collection = "ctl_prueba")
@JsonIgnoreProperties("_class")
public class prueba {
    @Id // Mark this field as the ID
    @Getter
    @Setter
    private ObjectId id; // Can be ObjectId, String, or other supported type
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private double price;

    // Getters, setters, and other methods

    public prueba(ObjectId id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}