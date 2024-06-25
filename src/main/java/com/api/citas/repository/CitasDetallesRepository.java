/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.citas.repository;

import com.api.citas.dto.DetalleCitas;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alejandro.bueno
 */
@Repository
public interface CitasDetallesRepository extends MongoRepository<DetalleCitas, String>{
    
    public List<DetalleCitas> findByIdCita(int id);
    public void deleteByIdCitaAndNumProd(int id, int numProd);
    public void deleteByIdCita(int id);
    


}
