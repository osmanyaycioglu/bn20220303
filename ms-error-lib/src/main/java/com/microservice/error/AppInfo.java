package com.microservice.error;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "app.info")
public class AppInfo {

    private String boundedContext;
    private String domain;
    private String microservice;

    public String getBoundedContext() {
        return this.boundedContext;
    }

    public void setBoundedContext(final String boundedContextParam) {
        this.boundedContext = boundedContextParam;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(final String domainParam) {
        this.domain = domainParam;
    }

    public String getMicroservice() {
        return this.microservice;
    }

    public void setMicroservice(final String microserviceParam) {
        this.microservice = microserviceParam;
    }


}
