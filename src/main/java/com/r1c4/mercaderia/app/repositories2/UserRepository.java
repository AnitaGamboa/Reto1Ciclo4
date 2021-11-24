/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.r1c4.mercaderia.app.repositories2;

import com.r1c4.mercaderia.app.entities.User;
import com.r1c4.mercaderia.app.repositories.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anita
 */
@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    /*
    Traer los datos de la tabla
     */
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();

    }

    /**
     * 
     *  public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
     */
    public Optional<User> getById(int id) {
        return userCrudRepository.findById(id);
    }
       
    public User save(User user) {
        return userCrudRepository.save(user);
    }

    
     //retorna el usuario si el email existe
    public Optional<User> getByEmail(String  email){
        return userCrudRepository.findByEmail(email);
    }

     public boolean verificarEmail(String email) {
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        return usuario.isPresent();
     }
     
    public Optional<User> autenticarUsuario(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    /**
     * DELETE FROM TABLE
     *
     * @param user
     */
    public void delete(User user) {
        userCrudRepository.delete(user);
    }

}
