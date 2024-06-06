/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.citas.repository;

import com.api.citas.dto.HojaClinica;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alejandro.bueno
 */
@Repository
public interface HojaClinicaRepository extends MongoRepository<HojaClinica, String>{
 
    public HojaClinica findByIdCita(int id);
    public void deleteByIdCita(int id);
}
