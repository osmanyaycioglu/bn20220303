package com.training.spring.restclient.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(final RequestTemplate templateParam) {
        templateParam.header("X-Origin",
                             "restaurant-order.order");
    }

}
