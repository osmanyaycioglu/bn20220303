package com.training.spring.order.rest.models;

import java.util.List;

import com.training.spring.restaurant.rest.models.Meal;

public class OrderRest {

    private String     phone;
    private String     name;
    private String     surname;
    private List<Meal> meals;

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(final String phoneParam) {
        this.phone = phoneParam;
    }

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

    public List<Meal> getMeals() {
        return this.meals;
    }

    public void setMeals(final List<Meal> mealsParam) {
        this.meals = mealsParam;
    }

}
