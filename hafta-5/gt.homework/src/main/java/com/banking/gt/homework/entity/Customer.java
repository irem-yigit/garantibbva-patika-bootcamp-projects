package com.banking.gt.homework.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name" , length = 50, nullable = false)
    private String name;

    @Column(name = "surname" , length = 50, nullable = false)
    private String surname;

    @Column(name = "identityNo", length = 11, nullable = false)
    private Integer identityNo;

    @Column(name = "password" , length = 400, nullable = false)
    private String password;

    @Column(name = "email" , length = 50, nullable = false)
    private String email;

    @Column(name = "phoneNumber" , length = 15, nullable = false)
    private Integer phoneNumber;


}
