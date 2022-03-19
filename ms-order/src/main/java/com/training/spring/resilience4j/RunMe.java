package com.training.spring.resilience4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.Retry.Metrics;
import io.github.resilience4j.retry.RetryRegistry;

//@Component
public class RunMe implements CommandLineRunner {

    @Autowired
    private Caller                 caller;

    @Autowired
    private RetryRegistry          rr;

    @Autowired
    private CircuitBreakerRegistry crr;

    @Override
    public void run(final String... argsParam) throws Exception {
        Retry retryLoc = this.rr.retry("abcretry");
        io.github.resilience4j.circuitbreaker.CircuitBreaker circuitBreakerLoc = this.crr.circuitBreaker("mycb");
        retryLoc.getEventPublisher()
                .onRetry(t -> System.out.println("Retried : " + t.getNumberOfRetryAttempts()));
        circuitBreakerLoc.getEventPublisher()
                         .onStateTransition(t -> System.out.println("**** State changed : "
                                                                    + t.getStateTransition()
                                                                       .getToState()));
        Metrics retryMetricsLoc = retryLoc.getMetrics();
        io.github.resilience4j.circuitbreaker.CircuitBreaker.Metrics metricsLoc = circuitBreakerLoc.getMetrics();
        for (int iLoc = 0; iLoc < 40; iLoc++) {
            try {
                Thread.sleep(500);
                System.out.println("state : "
                                   + circuitBreakerLoc.getState()
                                   + " test-result : "
                                   + iLoc
                                   + " ---> "
                                   + this.caller.testMe("test-" + iLoc));
                // System.out.println("Number of retry " + retryMetricsLoc.getNumberOfSuccessfulCallsWithRetryAttempt());
            } catch (Exception eLoc) {
                System.out.println("state : "
                                   + circuitBreakerLoc.getState()
                                   + " test-error : "
                                   + iLoc
                                   + " exp : "
                                   + eLoc.getClass()
                                         .getName());
            }
        }
    }

}
