package com.microservice.error;


public class RestException extends RuntimeException {

    private static final long serialVersionUID = -4768496337123693148L;

    private ErrorObj          errorObj;

    public RestException() {
    }

    public RestException(final ErrorObj errorObjParam) {
        super();
        this.errorObj = errorObjParam;
    }


    public ErrorObj getErrorObj() {
        return this.errorObj;
    }


    public void setErrorObj(final ErrorObj errorObjParam) {
        this.errorObj = errorObjParam;
    }


}
