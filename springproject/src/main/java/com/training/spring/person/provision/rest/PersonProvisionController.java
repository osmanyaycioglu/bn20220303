package com.training.spring.person.provision.rest;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.rest.Person;

@RestController
@RequestMapping("/api/v1/person/provision")
@Validated
public class PersonProvisionController {

    @PostMapping("/activate")
    public String activate(@Validated @RequestBody final Person personParam) {
        if ((personParam.getName() == null)
            || personParam.getName()
                          .isEmpty()) {
            throw new IllegalArgumentException();
        }
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
