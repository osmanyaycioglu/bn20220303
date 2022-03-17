package com.training.spring.person.provision.rest.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.training.spring.custom.validation.StartWith;

public class PersonRest {

    @NotEmpty
    @Size(min = 2, max = 20, message = "name 2 ile 20 arasında olmalı")
    @StartWith(value = "n:")
    private String  name;
    @NotEmpty
    @Size(min = 3, max = 25, message = "name 3 ile 25 arasında olmalı")
    @StartWith(value = "s:")
    private String  surname;
    @Positive
    @Min(50)
    @Max(300)
    private Integer height;
    @Positive
    @Min(10)
    @Max(300)
    private Integer weight;

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


}
