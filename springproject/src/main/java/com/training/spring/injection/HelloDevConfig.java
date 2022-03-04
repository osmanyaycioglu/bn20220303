package com.training.spring.injection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class HelloDevConfig {

    @Bean
    public IHello dynHello2() {
        return new HelloEng();
    }

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
