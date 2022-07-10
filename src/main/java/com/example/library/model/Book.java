package com.example.library.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "book_id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "year_of_birth")
    private int yearOfBirth;

    public Book(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public Book() {

    }
}
