package com.microservice.error.feign;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservice.error.ErrorObj;
import com.microservice.error.RestException;

import feign.Response;
import feign.Response.Body;
import feign.codec.ErrorDecoder;

public class GeneralFeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(final String methodKeyParam,
                            final Response responseParam) {
        try {
            Body bodyLoc = responseParam.body();
            ObjectMapper mapperLoc = new ObjectMapper();
            ErrorObj remoteErrorLoc = mapperLoc.readValue(bodyLoc.asInputStream(),
                                                          ErrorObj.class);
            return new RestException(remoteErrorLoc);
        } catch (Exception eLoc) {
            return new ErrorDecoder.Default().decode(methodKeyParam,
                                                     responseParam);
        }
    }

}
