/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.r1c4.mercaderia.app.repositories.crud;

import com.r1c4.mercaderia.app.entities.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author anita
 */
public interface UserCrudRepository extends CrudRepository<User, Integer> {

  //  @Query("select u from User u where u.email = ?1 and u.password = ?2")
    Optional<User> findByEmailAndPassword(String email, String password);

 //   @Query( "select user from User user where user.email =?1")
    Optional<User> findByEmail(String email);

}
