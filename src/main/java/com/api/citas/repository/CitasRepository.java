package com.api.citas.repository;

import com.api.citas.dto.Citas;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alejandro.bueno
 */
@Repository
public interface CitasRepository extends MongoRepository<Citas, String> {

    public List<Citas> findByCliente(String cliente);
    public Citas findByIdCita(int id);
    public List<Citas> findByIdCitaAndCliente(int id, String cliente);
    public List<Citas> findByClienteContaining(String cliente);
    public List<Citas> findByClienteContainingAndIdCita(String cliente, int id);
    public List<Citas> findByClienteContainingAndIdCitaAndFechaBetween(String cliente, int id, LocalDateTime fechaInicio,LocalDateTime fechaFin);
    public List<Citas> findByIdCitaAndFechaBetween(int id, LocalDateTime fechaInicio,LocalDateTime fechaFin);
    public List<Citas> findByClienteContainingAndFechaBetween(String cliente, LocalDateTime fechaInicio,LocalDateTime fechaFin);

    public void deleteByIdCita(int id);
    
    public Citas findTopByOrderByIdCitaDesc();
    
    public List<Citas> findByFecha(Date fecha);
      
    public List<Citas> findByFechaBetween(LocalDateTime fechaInicio,LocalDateTime fechaFin);

    

}
