package com.training.spring.rest.error;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.training.spring.error.ErrorObj;

@RestControllerAdvice
public class ErrorAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(final IllegalArgumentException exp) {
        return ErrorObj.newInstance()
                       .setErrorCode(1002)
                       .setMessage(exp.getMessage());
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(value = HttpStatus.EXPECTATION_FAILED)
    public ErrorObj handleException(final IllegalStateException exp) {
        return ErrorObj.newInstance()
                       .setErrorCode(1004)
                       .setMessage(exp.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorObj handleException(final MethodArgumentNotValidException exp) {
        ErrorObj rootError = ErrorObj.newInstance()
                                     .setErrorCode(1020)
                                     .setMessage("Validasyon patladı.");
        List<ObjectError> allErrorsLoc = exp.getAllErrors();
        for (ObjectError objectErrorLoc : allErrorsLoc) {
            rootError.addSubError(ErrorObj.newInstance()
                                          .setErrorCode(1021)
                                          .setMessage(objectErrorLoc.toString()));
        }
        return rootError;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObj> handleException(final Exception exp) {
        if (exp instanceof NullPointerException) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                                 .body(ErrorObj.newInstance()
                                               .setErrorCode(5001)
                                               .setMessage(exp.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(ErrorObj.newInstance()
                                           .setErrorCode(5000)
                                           .setMessage(exp.getMessage()));
    }
}
