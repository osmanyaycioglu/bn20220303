package com.training.spring.person.provision.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.training.spring.person.provision.models.Person;
import com.training.spring.person.provision.rest.models.PersonRest;

@Mapper
public interface IPersonMapper {

    IPersonMapper mapper = Mappers.getMapper(IPersonMapper.class);

    Person toPerson(PersonRest personRestParam);

    PersonRest fromPerson(Person personParam);

    List<Person> toPersons(List<PersonRest> personRestParam);

    List<PersonRest> fromPersons(List<Person> personRestParam);


}
