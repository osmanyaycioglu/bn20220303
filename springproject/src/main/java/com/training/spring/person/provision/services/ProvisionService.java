package com.training.spring.person.provision.services;

import org.springframework.stereotype.Service;

import com.training.spring.person.provision.models.Person;

@Service
public class ProvisionService {

    public String activate(final Person personParam) {
        return "OK";
    }

}
