package com.training.spring.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@Profile("live")
@Configuration
public class HelloConfig {

    //    @Value("${app.hello.type}")
    //    private String langType;

    @Autowired
    private Environment        env;

    @Autowired
    private ApplicationContext ac;

    @Autowired
    private AppConfig          apconf;

    @Bean
    public IHello dynHello3() {
        System.out.println(this.apconf);
        switch (this.apconf.getHelloLanguage()) {
            case "eng":
                return new HelloEng();
            case "tr":
                return new HelloTr();
            default:
                return new HelloEng();
        }
    }

    @Bean
    public IHello dynHello2() {
        String langType = this.env.getProperty("app.hello.type");
        langType = this.ac.getEnvironment()
                          .getProperty("app.hello.type");
        switch (langType) {
            case "eng":
                return new HelloEng();
            case "tr":
                return new HelloTr();
            default:
                return new HelloEng();
        }
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
