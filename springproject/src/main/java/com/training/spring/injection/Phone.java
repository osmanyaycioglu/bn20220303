package com.training.spring.injection;


public class Phone {

    private String name;
    private String number;

    public String getName() {
        return this.name;
    }

    public void setName(final String nameParam) {
        this.name = nameParam;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(final String numberParam) {
        this.number = numberParam;
    }

    @Override
    public String toString() {
        return "Phone [name=" + this.name + ", number=" + this.number + "]";
    }


}
