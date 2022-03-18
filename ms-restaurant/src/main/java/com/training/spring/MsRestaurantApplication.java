package com.training.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

import com.microservice.error.ErrorConfig;

@SpringBootApplication
@Import(ErrorConfig.class)
@EnableEurekaClient
public class MsRestaurantApplication {

    public static void main(final String[] args) {
        SpringApplication.run(MsRestaurantApplication.class,
                              args);
    }

}
