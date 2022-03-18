package com.training.spring.person.provision.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.person.provision.data.PersonDataStorage;
import com.training.spring.person.provision.models.Person;

@Service
public class ProvisionService {

    @Autowired
    private PersonDataStorage dataStorage;

    public Long activate(final Person personParam) {
        return this.dataStorage.insert(personParam);
    }

}
