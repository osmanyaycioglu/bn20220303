package com.training.spring.person.provision.rest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.person.provision.rest.models.PersonRest;

@RestController
@RequestMapping("/api/v1/person/provision")
public class PersonProvisionControllerDesign2 {

    @PutMapping("/activate")
    public String activate(@RequestBody final PersonRest personParam) {
        return "OK";
    }

    @DeleteMapping("/deactivate")
    public String deactivate(@RequestParam("personid") final Long personId) {
        return "OK";
    }

    @PostMapping("/suspend")
    public String suspend(@RequestParam("personid") final Long personId) {
        return "OK";
    }

}
