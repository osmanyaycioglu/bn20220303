package com.training.spring.person.provision.persist;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.training.spring.person.provision.models.Person;

public interface IPersonDao extends CrudRepository<Person, Long> {

    List<Person> findByName(String name);

    List<Person> findBySurname(String surname);

    List<Person> findByNameAndSurname(String name);

    //Optional<List<Person>> findByNameAndSurname(String name);

    List<Person> findByNameAndSurnameOrderByName(String name);

    List<Person> findByNameIn(List<String> names);

    List<Person> findByNameLike(String likeName);

    @Query("select p from Person p where p.name=?1")
    List<Person> searchName(String name);

    @Query(value = "select * from person p where p.name=?1", nativeQuery = true)
    List<Person> searchNameNative(String name);

}
