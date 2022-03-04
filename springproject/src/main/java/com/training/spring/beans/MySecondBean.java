package com.training.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MySecondBean {

    @Autowired
    @Qualifier("myFirstBean")
    private MyFirstBean myFirstBean;

    public String second(final String str) {
        return this.myFirstBean.first(str);
    }

}
