package com.example.library.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
}
