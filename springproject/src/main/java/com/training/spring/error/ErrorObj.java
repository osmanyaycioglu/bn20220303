package com.training.spring.error;

import java.util.ArrayList;
import java.util.List;

public class ErrorObj {

    private List<ErrorObj> subErrors;
    private String         message;
    private Integer        errorCode;

    public static ErrorObj newInstance() {
        return new ErrorObj();
    }

    public static void main(final String[] args) {
        ErrorObj e1 = newInstance().setErrorCode(1002)
                                   .setMessage("error 1")
                                   .addSubError(newInstance().setErrorCode(1003)
                                                             .setMessage("sub error 1"));
    }

    public ErrorObj addSubError(final ErrorObj errorObjParam) {
        if (this.subErrors == null) {
            this.subErrors = new ArrayList<ErrorObj>();
        }
        this.subErrors.add(errorObjParam);
        return this;
    }

    public List<ErrorObj> getSubErrors() {
        return this.subErrors;
    }

    public ErrorObj setSubErrors(final List<ErrorObj> subErrorsParam) {
        this.subErrors = subErrorsParam;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public ErrorObj setMessage(final String messageParam) {
        this.message = messageParam;
        return this;
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }

    public ErrorObj setErrorCode(final Integer errorCodeParam) {
        this.errorCode = errorCodeParam;
        return this;
    }


}
