package com.training.spring.resilience4j;

import org.springframework.stereotype.Component;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Component
public class Callee {

    private int attempt = 0;

    @Retry(name = "abcretry", fallbackMethod = "testFallback")
    @CircuitBreaker(name = "mycb")
    public String test(final String str) {
        System.out.println("Called attempt : " + this.attempt + " ---- " + str);
        this.attempt++;
        if ((this.attempt < 12) && ((this.attempt % 3) == 0)) {
            throw new IllegalArgumentException("xyz");
        }
        return this.attempt + " Hello " + str;
    }

    public String testFallback(final String str,
                               final Throwable throwableParam) {
        return "Fallback : " + str;
    }

}
