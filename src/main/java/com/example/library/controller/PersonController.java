package com.example.library.controller;

import com.example.library.dao.PersonRepo;
import com.example.library.service.PersonService;
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
    private final PersonService personService;

    public PersonController(PersonRepo personRepo, PersonService personService) {
        this.personRepo = personRepo;
        this.personService = personService;
    }

    @GetMapping()
    public String getAllPerson(Model model) {
        model.addAttribute("people", personRepo.findAll());
        return "person/people";
    }

    @PostMapping("/add")
    public String addBook(@RequestParam(name = "name") String name, @RequestParam(name = "age") int age, Model model) {
        personService.savePerson(name, age, personRepo);
        model.addAttribute("people", personRepo.findAll());
        return "redirect:/people";
    }

    @PostMapping("/deleteAll")
    public String deleteAll(Model model) {
        personService.deleteAll(personRepo);
        model.addAttribute("people", personRepo.findAll());
        return "redirect:/people";
    }
}
