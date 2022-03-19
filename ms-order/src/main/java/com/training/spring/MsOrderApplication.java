package com.training.spring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.microservice.error.ErrorConfig;
import com.microservice.error.feign.FeignErrorConfig;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@Import({
          ErrorConfig.class,
          FeignErrorConfig.class
})
public class MsOrderApplication {

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    public static void main(final String[] args) {
        SpringApplication.run(MsOrderApplication.class,
                              args);
    }

    @PostConstruct
    public void init() {
        System.out.println("INIT ----------------------------------");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("DESTROY ----------------------------------");
    }


}
