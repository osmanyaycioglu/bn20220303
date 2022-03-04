package com.training.spring.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
//@Controller
//@Service
//@Repository
//@Configuration
public class CommandRunner1 implements CommandLineRunner {

    // Field Injection
    @Autowired
    //@Qualifier("myFirstBean")
    @Qualifier("bean-first")
    private MyFirstBean firstBean1;

    // Field Injection
    @Autowired
    //@Qualifier("xyz")
    @Qualifier("bean-xyz")
    private MyFirstBean       firstBean2;

    private final MyFirstBean firstBean3;

    private MyFirstBean       firstBean4;

    // Constructor Injection
    // @Autowired
    public CommandRunner1(@Qualifier("xyz") final MyFirstBean firstBean) {
        this.firstBean3 = firstBean;
    }

    // Method Injection
    @Autowired
    public void gtp(@Qualifier("myFirstBean") final MyFirstBean firstBean) {
        this.firstBean4 = firstBean;
    }

    @PostConstruct
    public void init() {
        System.out.println("PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PreDestroy");
    }

    @Override
    public void run(final String... argsParam) throws Exception {
        System.out.println("-------------1--------------");
        System.out.println(this.firstBean1.first("osman"));
        System.out.println(this.firstBean1.first("osman"));
        System.out.println(this.firstBean1.first("osman"));
        System.out.println("-------------2--------------");
        System.out.println(this.firstBean2.first("osman"));
        System.out.println(this.firstBean2.first("osman"));
        System.out.println(this.firstBean2.first("osman"));
        System.out.println("-------------3--------------");
        System.out.println(this.firstBean3.first("osman"));
        System.out.println(this.firstBean3.first("osman"));
        System.out.println(this.firstBean3.first("osman"));
        System.out.println("-------------4--------------");
        System.out.println(this.firstBean4.first("osman"));
        System.out.println(this.firstBean4.first("osman"));
        System.out.println(this.firstBean4.first("osman"));

    }

}
