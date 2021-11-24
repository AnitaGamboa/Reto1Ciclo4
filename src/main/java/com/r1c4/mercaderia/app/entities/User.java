package com.r1c4.mercaderia.app.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author anita
 */
@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor

@NoArgsConstructor
@Table(name = "user", indexes = @Index(name = "indx_email", columnList = "user_email", unique = true))
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(name = "user_email", length = 250, unique = true)
    private String email;
    @Column(length = 45, nullable = false)
    private String password;
    @Column(length = 45)
    private String name;

}
