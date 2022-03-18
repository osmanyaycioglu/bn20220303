package com.training.spring.restaurant.rest.models;


public class Meal {

    private String  mealName;
    private Integer amount;

    public String getMealName() {
        return this.mealName;
    }

    public void setMealName(final String mealNameParam) {
        this.mealName = mealNameParam;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(final Integer amountParam) {
        this.amount = amountParam;
    }


}
