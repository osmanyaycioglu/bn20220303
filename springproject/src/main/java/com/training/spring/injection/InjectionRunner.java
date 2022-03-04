package com.training.spring.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InjectionRunner implements CommandLineRunner {

    @Autowired
    @Qualifier("dynHello")
    private IHello hello;

    @Override
    public void run(final String... argsParam) throws Exception {
        System.out.println("--------------Hello-------------------");
        System.out.println(this.hello.hello("osman"));

    }

}
