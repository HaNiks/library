package com.example.library.controller;

import com.example.library.dao.BookDAO;
import com.example.library.dao.BookRepo;
import com.example.library.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/books")
public class BookController {

    private final BookRepo bookRepo;
    private final BookDAO bookDAO;


    public BookController(BookRepo bookRepo, BookDAO bookDAO) {
        this.bookRepo = bookRepo;
        this.bookDAO = bookDAO;
    }

    @GetMapping()
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookRepo.findAll());
        return "book/books";
    }

    @GetMapping("/add")
    public String showAddPage() {
        return "book/new";
    }

    @PostMapping("/add")
    public String addBook(@RequestParam(name = "name") String name, @RequestParam(name = "yearOfBirth") int yearOfBirth, Model model) {
        bookRepo.save(new Book(name, yearOfBirth));
        model.addAttribute("books", bookRepo.findAll());
        return "redirect:/books";
    }

    @PostMapping("/deleteAll")
    public String deleteAll(Model model) {
        bookRepo.deleteAll();
        model.addAttribute("books", bookRepo.findAll());
        return "redirect:/books";
    }

    @GetMapping("/{id}")
    public String showEditPage(@PathVariable(name = "id") long id, Model model) {
        model.addAttribute("books", bookRepo.findById(id).get());
        return "book/show";
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable(name = "id") long id, Model model, @RequestParam(name = "name") String name,
                       @RequestParam(name = "yearOfBirth") int yearOfBirth) {
        model.addAttribute("books", bookDAO.update(bookRepo.findById(id).get(), name, yearOfBirth));
        return "redirect:/books";
    }
}
