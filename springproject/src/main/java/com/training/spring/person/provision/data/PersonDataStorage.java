package com.training.spring.person.provision.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.person.provision.models.Person;
import com.training.spring.person.provision.persist.IPersonDao;

@Service
public class PersonDataStorage {

    @Autowired
    private IPersonDao personDao;

    public Long insert(final Person personParam) {
        Person saveLoc = this.personDao.save(personParam);
        return saveLoc.getPersonId();
    }

    public void delete(final Long perId) {
        this.personDao.deleteById(perId);
    }

    public void update(final Person personParam) {
        this.personDao.save(personParam);
    }

    public Person getOne(final Long personId) {
        return this.personDao.findById(personId)
                             .orElse(null);
    }

    public List<Person> getAll() {
        Iterable<Person> findAllLoc = this.personDao.findAll();
        List<Person> listLoc = new ArrayList<>();
        for (Person personLoc : findAllLoc) {
            listLoc.add(personLoc);
        }
        return listLoc;
    }

    public List<Person> getByName(final String name) {
        return this.personDao.findByName(name);
    }

    public List<Person> getBySurname(final String name) {
        return this.personDao.findBySurname(name);
    }

    public List<Person> getByPhone(final String phone) {
        return this.personDao.findByPhone(phone);
    }


}
