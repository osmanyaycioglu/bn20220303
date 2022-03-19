package com.training.spring.resilience4j;

import java.util.function.Predicate;

public class ResultRetryPredicate implements Predicate<String> {

    @Override
    public boolean test(final String tParam) {
        return tParam.contains("0");
    }

}
