package com.ormb.app.ormbapp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ormb.app.ormbapp.entities.Person;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController

public class PersonController {


@PostMapping("/addPerson")
public String postMethodName(@RequestBody String entity) {
    return entity;
}


// @PostMapping("/add")
//     public Person addPerson(@RequestBody Person person) {
//         return personService.savePerson(person);
//     }


}
