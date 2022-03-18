package com.training.spring.person.provision.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.person.provision.data.PersonDataStorage;
import com.training.spring.person.provision.models.Person;

@Service
public class PersonQueryService {

    @Autowired
    private PersonDataStorage personDataStorage;

    public List<Person> getByPhone(final String phoneParam) {
        return this.personDataStorage.getByPhone(phoneParam);
    }

    public Long getIdByPhone(final String phoneParam) {
        List<Person> byPhoneLoc = this.personDataStorage.getByPhone(phoneParam);
        if ((byPhoneLoc != null) && (byPhoneLoc.size() > 0)) {
            return byPhoneLoc.get(0)
                             .getPersonId();
        }
        return null;
    }


}
