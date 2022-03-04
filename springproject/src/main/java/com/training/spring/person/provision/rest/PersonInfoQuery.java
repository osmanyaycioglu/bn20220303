package com.training.spring.person.provision.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.rest.Person;

@RestController
@RequestMapping("/api/v1/person/info/query")
public class PersonInfoQuery {

    @GetMapping("/get/single")
    public Person getSingle(@RequestParam("personid") final Long personId) {
        return null;
    }

    @GetMapping("/get/all")
    public List<Person> getAll() {
        return null;
    }

    @GetMapping("/get/by/name")
    public List<Person> getByName(@RequestParam("name") final String name) {
        return null;
    }

    @GetMapping("/get/by/surname")
    public List<Person> getBySurname(@RequestParam("surname") final String surname) {
        return null;
    }

}
