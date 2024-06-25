/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.citas.repository;

import com.api.citas.dto.Inventario;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alejandro.bueno
 */
@Repository
public interface InventarioRepository extends MongoRepository<Inventario, String>{
    public Inventario findByIdProc(int id);
    public void deleteByIdProc(int id);
    
    @Override
    public Inventario save(Inventario inventario);
           
}
