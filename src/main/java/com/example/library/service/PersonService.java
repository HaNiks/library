package com.example.library.service;

import com.example.library.dao.PersonRepo;
import com.example.library.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    public void savePerson(String name, int age, PersonRepo personRepo) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        personRepo.save(person);
    }

    public void deleteAll(PersonRepo personRepo) {
        personRepo.deleteAll();
    }
}
