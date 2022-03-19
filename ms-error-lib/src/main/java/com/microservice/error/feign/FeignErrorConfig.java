package com.microservice.error.feign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignErrorConfig {

    @Bean
    public GeneralFeignErrorDecoder generalFeignErrorDecoder() {
        return new GeneralFeignErrorDecoder();
    }

}
