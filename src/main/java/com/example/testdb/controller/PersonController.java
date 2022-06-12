package com.example.testdb.controller;

import com.example.testdb.entity.Person;
import com.example.testdb.repository.PersonsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonsRepository personsRepository;

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        personsRepository.save(person);
        var location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(person.getId()).toUri();
        return ResponseEntity.created(location).body(person);
    }

    @GetMapping
    public List<Person> getAll(){
        return personsRepository.findAll();
    }
}
