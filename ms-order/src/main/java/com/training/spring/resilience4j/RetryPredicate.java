package com.training.spring.resilience4j;

import java.util.function.Predicate;

import com.microservice.error.ErrorObj;
import com.microservice.error.RestException;

public class RetryPredicate implements Predicate<Throwable> {

    @Override
    public boolean test(final Throwable tParam) {
        if (tParam instanceof IllegalArgumentException) {
            return true;
        } else if (tParam instanceof RestException) {
            RestException exceptionLoc = (RestException) tParam;
            ErrorObj errorObjLoc = exceptionLoc.getErrorObj();
            if (errorObjLoc != null) {
                Integer errorCodeLoc = errorObjLoc.getErrorCode();
                switch (errorCodeLoc) {
                    case 3007:
                    case 3008:
                    case 10012:
                        return true;

                    default:
                        return false;
                }
            }
        }

        return false;
    }

}
