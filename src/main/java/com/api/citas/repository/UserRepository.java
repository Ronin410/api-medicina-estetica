/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.citas.repository;

import com.api.citas.dto.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alejandro.bueno
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    public User findByUser(String user);
    
    public Optional<User> findByIduser(int id);

    public User findByUserAndPass(String user, String pass);
    
    public List<User> findByPass(String pass);


}
