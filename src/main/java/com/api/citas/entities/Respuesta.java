/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.citas.entities;

import com.api.citas.util.Meta;

/**
 *
 * @author alejandro.bueno
 */
public class Respuesta {
    private Meta meta;
    private Object data;

    public Respuesta(Meta meta, Object data) {
        this.meta = meta;
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

   

}
