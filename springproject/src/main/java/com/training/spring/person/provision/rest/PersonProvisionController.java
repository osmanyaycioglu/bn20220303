package com.training.spring.person.provision.rest;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.person.provision.mapper.IPersonMapper;
import com.training.spring.person.provision.rest.models.PersonRest;
import com.training.spring.person.provision.services.ProvisionService;

@RestController
@RequestMapping("/api/v1/person/provision")
@Validated
public class PersonProvisionController {

    @Autowired
    private ProvisionService ps;

    @PostMapping("/activate")
    public String activate(@Validated @RequestBody final PersonRest personParam) {
        if ((personParam.getName() == null)
            || personParam.getName()
                          .isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.ps.activate(IPersonMapper.mapper.toPerson(personParam));
        return "OK";
    }

    @GetMapping("/deactivate")
    public String deactivate(@NotNull @RequestParam("personid") final Long personId) {
        return "OK";
    }

    @GetMapping("/suspend")
    public String suspend(@NotNull @RequestParam("personid") final Long personId) {
        return "OK";
    }

}

