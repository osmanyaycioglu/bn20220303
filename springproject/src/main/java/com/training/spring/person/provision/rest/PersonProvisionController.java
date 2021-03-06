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

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/person/provision")
@Validated
public class PersonProvisionController {

    @Autowired
    private ProvisionService ps;

    @PostMapping("/activate")
    @Operation(description = "Person will be activated and written to db",
               summary = "activate person",
               tags = "apigroup1")
    public Long activate(@Validated @RequestBody final PersonRest personParam) {
        if ((personParam.getName() == null)
            || personParam.getName()
                          .isEmpty()) {
            throw new IllegalArgumentException();
        }
        System.out.println("---------------/api/v1/person/provision/activate : " + personParam);
        return this.ps.activate(IPersonMapper.mapper.toPerson(personParam));
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

