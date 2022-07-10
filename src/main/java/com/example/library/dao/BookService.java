package com.example.library.dao;

import com.example.library.model.Book;
import org.springframework.stereotype.Service;


@Service
public class BookService {

    public void saveBook(String name,int yearOfBirth, BookRepo bookRepo) {
        Book book = new Book();
        book.setName(name);
        book.setYearOfBirth(yearOfBirth);
        bookRepo.save(book);
    }

    public void deleteAll(BookRepo bookRepo) {
        bookRepo.deleteAll();
    }
}
