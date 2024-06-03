/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.citas.repository;

import com.api.citas.dto.Inventario;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alejandro.bueno
 */
@Repository
public interface InventarioRepository extends MongoRepository<Inventario, String>{
    public List<Inventario> findByIdProc(int id);
    public void deleteByIdProc(int id);

    /*
    public List<Inventario> findByCliente(String cliente);
    public List<Inventario> findByIdCitaAndCliente(int id, String cliente);
    public List<Inventario> findByClienteContaining(String cliente);
    public List<Inventario> findByClienteContainingAndIdCita(String cliente, int id);
    */
    
    //public Citas findTopByOrderByIdCitaDesc();
}
