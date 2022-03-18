package com.training.spring.person.provision.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.person.provision.mapper.IPersonMapper;
import com.training.spring.person.provision.rest.models.PersonRest;
import com.training.spring.person.provision.services.PersonQueryService;

@RestController
@RequestMapping("/api/v1/person/info/query")
public class PersonInfoQuery {

    @Autowired
    private PersonQueryService pqs;

    @GetMapping("/get/single")
    public PersonRest getSingle(@RequestParam("personid") final Long personId) {
        return null;
    }

    @GetMapping("/get/all")
    public List<PersonRest> getAll() {
        return null;
    }

    @GetMapping("/get/by/name")
    public List<PersonRest> getByName(@RequestParam("name") final String name) {
        return null;
    }

    @GetMapping("/get/by/surname")
    public List<PersonRest> getBySurname(@RequestParam("surname") final String surname) {
        return null;
    }

    @GetMapping("/get/by/phone")
    public List<PersonRest> getByPhone(@RequestParam("phone") final String phone) {
        return IPersonMapper.mapper.fromPersons(this.pqs.getByPhone(phone));
    }

    @GetMapping("/get/id/by/phone")
    public Long getIdByPhone(@RequestParam("phone") final String phone) {
        System.out.println("---------------/api/v1/person/info/query/get/id/by/phone : " + phone);
        return this.pqs.getIdByPhone(phone);
    }

}
