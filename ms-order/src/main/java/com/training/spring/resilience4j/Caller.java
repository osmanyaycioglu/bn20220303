package com.training.spring.resilience4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Caller {

    @Autowired
    private Callee callee;

    public String testMe(final String str) {
        return this.callee.test(str);
    }


}
