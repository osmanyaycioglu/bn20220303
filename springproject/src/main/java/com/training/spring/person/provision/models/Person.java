package com.training.spring.person.provision.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long    personId;
    private String  name;
    private String  surname;
    private Integer height;
    private Integer weight;
    private String  phone;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(final String surnameParam) {
        this.surname = surnameParam;
    }

    public Integer getHeight() {
        return this.height;
    }

    public void setHeight(final Integer heightParam) {
        this.height = heightParam;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public void setWeight(final Integer weightParam) {
        this.weight = weightParam;
    }

    @Override
    public String toString() {
        return "Person [name="
               + this.name
               + ", surname="
               + this.surname
               + ", height="
               + this.height
               + ", weight="
               + this.weight
               + "]";
    }

    public Long getPersonId() {
        return this.personId;
    }

    public void setPersonId(final Long personIdParam) {
        this.personId = personIdParam;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(final String phoneParam) {
        this.phone = phoneParam;
    }

}
