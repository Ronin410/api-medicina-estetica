/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.citas.entities;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author alejandro.bueno
 */

public class Credenciales {
    @Getter
    @Setter
    private String usuario;
    @Getter
    @Setter
    private String pass;

    public Credenciales(String usuario, String pass) {
        this.usuario = usuario;
        this.pass = pass;
    }
}
