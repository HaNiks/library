package com.example.library.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "person_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
}
