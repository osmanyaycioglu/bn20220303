package com.training.spring.restaurant.rest.models;

import java.util.List;

import javax.validation.constraints.Negative;


public class Menu {

    @Negative
    private Long       personId;
    private List<Meal> meals;


    public List<Meal> getMeals() {
        return this.meals;
    }


    public void setMeals(final List<Meal> mealsParam) {
        this.meals = mealsParam;
    }


    public Long getPersonId() {
        return this.personId;
    }


    public void setPersonId(final Long personIdParam) {
        this.personId = personIdParam;
    }


    @Override
    public String toString() {
        return "Menu [personId=" + this.personId + ", meals=" + this.meals + "]";
    }


}
