/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.r1c4.mercaderia.app.controllers;

import com.r1c4.mercaderia.app.entities.User;
import com.r1c4.mercaderia.app.services.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author anita
 */
@RestController
@RequestMapping("/api/user/")
@CrossOrigin( "*")

public class UserController {
 @Autowired
    private UserService userService;
   /**
    * Recuperar todos los usuarios
    * @return 
    */
    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }
    //Registrar usuario

     @PostMapping("/new")
   @ResponseStatus(HttpStatus.CREATED)
   public User registrar (@RequestBody User user){
       return userService.registrar(user);
   }
   
   //autentica usuario
    @GetMapping("/{email}/{pasword}")
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.autenticarUsuario(email, password);
    }
    
    //autentica email
    @GetMapping("/{email}")
    public boolean verificarEmail(@PathVariable("email") String email) {
        return userService.verificarEmail(email);
    }
   
   
}
