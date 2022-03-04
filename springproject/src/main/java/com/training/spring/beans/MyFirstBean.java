package com.training.spring.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("bean-first")
// @Scope("prototype")
public class MyFirstBean {

    private int counter = 0;

    public String first(final String str) {
        this.counter++;
        return "First " + str + " counter : " + this.counter;
    }

}
