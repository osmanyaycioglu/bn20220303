package com.training.spring.injection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloConfig {

    //    @Value("${app.hello.type}")
    //    private String langType;

    @Bean
    public IHello dynHello(@Value("${app.hello.type}") final String langType) {
        switch (langType) {
            case "eng":
                return new HelloEng();
            case "tr":
                return new HelloTr();
            default:
                return new HelloEng();
        }
    }

}
