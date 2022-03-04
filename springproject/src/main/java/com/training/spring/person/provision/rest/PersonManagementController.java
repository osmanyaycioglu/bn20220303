package com.training.spring.person.provision.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.rest.Person;

@RestController
@RequestMapping("/api/v1/person/management")
public class PersonManagementController {

    @PostMapping("/update")
    public String update(@RequestBody final Person personParam) {
        return "OK";
    }

}
