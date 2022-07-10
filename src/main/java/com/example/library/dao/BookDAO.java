package com.example.library.dao;

import com.example.library.model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookDAO {

    public Book update(Book book, String name, int yearOfBirth) {
        return new Book(name, yearOfBirth);
    }
}
