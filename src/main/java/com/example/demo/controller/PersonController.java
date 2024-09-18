package com.example.demo.controller;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @PostMapping
    public Person save(@RequestBody Person person){
        Person  personaSave= personRepository.save(person);
        return personaSave;
    }

    @GetMapping
    public List<Person> getAll(){
        List<Person> personList = personRepository.findAll();
        return personList;
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable Long id,@RequestBody Person person){
        Person personFound = personRepository.findById(id).get();
        personFound.setName(person.getName());
        personFound.setLastName(person.getLastName());
        personFound.setAge(person.getAge());
         return personRepository.save(personFound);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        personRepository.deleteById(id);
    }
}
