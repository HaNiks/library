package com.example.library.controller;

import com.example.library.dao.PersonRepo;
import com.example.library.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/people")
public class PersonController {

    private final PersonRepo personRepo;

    public PersonController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @GetMapping()
    public String getAllPerson(Model model) {
        model.addAttribute("people", personRepo.findAll());
        return "person/people";
    }

    @GetMapping("/add")
    public String showNewPeoplePage() {
        return "person/new";
    }

    @PostMapping("/add")
    public String addBook(@RequestParam(name = "name") String name, @RequestParam(name = "age") int age, Model model) {
        personRepo.save(new Person(name, age));
        model.addAttribute("people", personRepo.findAll());
        return "redirect:/people";
    }

    @PostMapping("/deleteAll")
    public String deleteAll(Model model) {
        personRepo.deleteAll();
        model.addAttribute("people", personRepo.findAll());
        return "redirect:/people";
    }
}
