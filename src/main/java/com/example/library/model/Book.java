package com.example.library.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "book_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "year_of_birth")
    private int yearOfBirth;
}
