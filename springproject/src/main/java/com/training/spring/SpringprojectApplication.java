package com.training.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.microservice.error.ErrorConfig;

//@SpringBootApplication(scanBasePackages = {
//                                            "com.training.spring",
//                                            "com.microservice.error"
//})
@SpringBootApplication
@Import(ErrorConfig.class)
public class SpringprojectApplication {


    public static void main(final String[] args) {
        SpringApplication.run(SpringprojectApplication.class,
                              args);
    }

}
