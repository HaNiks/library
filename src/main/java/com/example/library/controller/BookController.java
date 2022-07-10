package com.example.library.controller;

import com.example.library.service.BookService;
import com.example.library.dao.BookRepo;
import com.example.library.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/books")
public class BookController {


    private final BookService bookService;

    private final BookRepo bookRepo;

    public BookController(BookService bookService, BookRepo bookRepo) {
        this.bookService = bookService;
        this.bookRepo = bookRepo;
    }

    @GetMapping()
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookRepo.findAll());
        return "book/books";
    }

    @GetMapping("/add")
    public String showFormAddPage() {
        return "book/new";
    }

    @PostMapping("/add")
    public String addBook(@RequestParam(name = "name") String name, @RequestParam(name = "yearOfBirth") int yearOfBirth, Model model) {
        bookService.saveBook(name, yearOfBirth, bookRepo);
        model.addAttribute("books", bookRepo.findAll());
        return "redirect:/books";
    }

    @PostMapping("/deleteAll")
    public String deleteAll(Model model) {
        bookService.deleteAll(bookRepo);
        model.addAttribute("books", bookRepo.findAll());
        return "redirect:/books";
    }
}
