package com.example.library.controller;

import com.example.library.dao.PersonRepo;
import com.example.library.model.Book;
import com.example.library.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public String showIdPage(@PathVariable(name = "id") long id, Model model) {
        model.addAttribute("people", personRepo.findById(id).get());
        return "person/show";
    }

    @GetMapping("/{id}/edit")
    public String showEditPage(@PathVariable(name = "id") long id, Model model) {
        model.addAttribute("person", personRepo.findById(id).get());
        return "person/edit";
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable(name = "id") long id, Model model, @RequestParam(name = "name") String name,
                       @RequestParam(name = "age") int age) {
        Person person = personRepo.findById(id).get();
        person.setName(name);
        person.setAge(age);
        model.addAttribute("person", personRepo.save(person));
        return "redirect:/people";
    }
}
