package com.example.library.controller;

import com.example.library.dao.PersonRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PersonController {

    private final PersonRepo personRepo;

    public PersonController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @GetMapping()
    public String getAllPerson(Model model) {
        model.addAttribute("allPerson", personRepo.findAll());
        return "people/people";
    }
}
