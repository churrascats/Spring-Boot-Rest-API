package com.example.demo.api;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/person")

public class PersonController {
    
    private final PersonService personService;

    @Autowired
    private PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping("{id}")
    public Person deletePeople(@PathVariable UUID id){
        return personService.GetPersonById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void deletePeopleById(@PathVariable UUID id){
        personService.deletePersonById(id);
    }

    @PutMapping("{id}")
    public void updatePeopleById(@PathVariable UUID id, @RequestBody Person person){
        personService.updatePersonById(id, person);
    }
}
