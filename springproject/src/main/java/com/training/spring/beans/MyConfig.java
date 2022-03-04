package com.training.spring.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    @Qualifier("bean-xyz")
    //@Primary
    public MyFirstBean xyz() {
        return new MyFirstBean();
    }

    @Bean
    @Qualifier("bean-abc")
    public MyFirstBean abc() {
        return new MyFirstBean();
    }

    @Bean
    @Qualifier("bean-fgh")
    public MyFirstBean fgh() {
        return new MyFirstBean();
    }


}
