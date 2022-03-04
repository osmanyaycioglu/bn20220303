package com.training.spring.injection;

import org.springframework.stereotype.Component;

@Component
public class HelloTr implements IHello {

    @Override
    public String hello(final String nameParam) {
        return "Selam " + nameParam;
    }

}
