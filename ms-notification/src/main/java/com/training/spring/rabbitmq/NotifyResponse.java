package com.training.spring.rabbitmq;


public class NotifyResponse {

    private String response;


    public String getResponse() {
        return this.response;
    }


    public void setResponse(final String responseParam) {
        this.response = responseParam;
    }


    @Override
    public String toString() {
        return "NotifyResponse [response=" + this.response + "]";
    }


}
