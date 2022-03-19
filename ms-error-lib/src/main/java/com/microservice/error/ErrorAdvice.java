package com.microservice.error;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestControllerAdvice
public class ErrorAdvice {

    @Autowired
    private AppInfo appInfo;

    private ErrorObj createBaseErrorObject() {
        return ErrorObj.newInstance()
                       .setMicroservice(this.appInfo.getMicroservice())
                       .setBoundedContext(this.appInfo.getBoundedContext())
                       .setDomain(this.appInfo.getDomain());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(final IllegalArgumentException exp) {
        return this.createBaseErrorObject()
                   .setErrorCode(1002)
                   .setMessage(exp.getMessage());
    }

    @ExceptionHandler(RestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(final RestException exp) {
        ErrorObj rootLoc = this.createBaseErrorObject()
                               .setErrorCode(3007)
                               .setMessage("Error while calling another microservice");
        rootLoc.addSubError(exp.getErrorObj());
        return rootLoc;
    }

    @ExceptionHandler(HttpStatusCodeException.class)
    @ResponseStatus(value = HttpStatus.BAD_GATEWAY)
    public ErrorObj handleException(final HttpStatusCodeException exp) {
        try {
            ErrorObj rootLoc = this.createBaseErrorObject()
                                   .setErrorCode(3007)
                                   .setMessage("Error while calling another microservice");
            byte[] responseBodyAsByteArrayLoc = exp.getResponseBodyAsByteArray();
            ObjectMapper mapperLoc = new ObjectMapper();
            rootLoc.addSubError(mapperLoc.readValue(responseBodyAsByteArrayLoc,
                                                    ErrorObj.class));
            return rootLoc;
        } catch (Exception eLoc) {
            return this.createBaseErrorObject()
                       .setErrorCode(5002)
                       .setMessage("Internal : " + exp.getMessage());

        }
    }

    @ExceptionHandler(UnknownHttpStatusCodeException.class)
    @ResponseStatus(value = HttpStatus.BAD_GATEWAY)
    public ErrorObj handleException(final UnknownHttpStatusCodeException exp) {
        try {
            ErrorObj rootLoc = this.createBaseErrorObject()
                                   .setErrorCode(3007)
                                   .setMessage(exp.getMessage());
            byte[] responseBodyAsByteArrayLoc = exp.getResponseBodyAsByteArray();
            ObjectMapper mapperLoc = new ObjectMapper();
            rootLoc.addSubError(mapperLoc.readValue(responseBodyAsByteArrayLoc,
                                                    ErrorObj.class));
            return rootLoc;

        } catch (Exception eLoc) {
            return this.createBaseErrorObject()
                       .setErrorCode(5002)
                       .setMessage("Internal : " + exp.getMessage());

        }
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
    public ErrorObj handleException(final IllegalStateException exp) {
        return this.createBaseErrorObject()
                   .setErrorCode(1004)
                   .setMessage(exp.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(final MethodArgumentNotValidException exp) {
        ErrorObj rootError = this.createBaseErrorObject()
                                 .setErrorCode(1020)
                                 .setMessage("Validasyon patladı.");
        List<ObjectError> allErrorsLoc = exp.getAllErrors();
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            rootError.addSubError(this.createBaseErrorObject()
                                      .setErrorCode(1021)
                                      .setMessage(objectErrorLoc.toString()));
        }
        return rootError;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObj> handleException(final Exception exp) {
        exp.printStackTrace();
        if (exp instanceof NullPointerException) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                                 .body(this.createBaseErrorObject()
                                           .setErrorCode(5001)
                                           .setMessage(exp.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(this.createBaseErrorObject()
                                       .setErrorCode(5000)
                                       .setMessage(exp.getMessage()));
    }
}
