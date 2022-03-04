package com.training.spring.injection;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.deneme.prop")
public class AppConfig {

    private String             helloLanguage;
    private List<String>       testList;
    private Phone              phone;
    private List<Phone>        phones;
    private Map<String, Phone> phoneMap;

    public Phone getPhone() {
        return this.phone;
    }

    public void setPhone(final Phone phoneParam) {
        this.phone = phoneParam;
    }

    public List<Phone> getPhones() {
        return this.phones;
    }

    public void setPhones(final List<Phone> phonesParam) {
        this.phones = phonesParam;
    }


    public Map<String, Phone> getPhoneMap() {
        return this.phoneMap;
    }


    public void setPhoneMap(final Map<String, Phone> phoneMapParam) {
        this.phoneMap = phoneMapParam;
    }


    public String getHelloLanguage() {
        return this.helloLanguage;
    }


    public void setHelloLanguage(final String helloLanguageParam) {
        this.helloLanguage = helloLanguageParam;
    }


    public List<String> getTestList() {
        return this.testList;
    }


    public void setTestList(final List<String> testListParam) {
        this.testList = testListParam;
    }

    @Override
    public String toString() {
        return "AppConfig [helloLanguage="
               + this.helloLanguage
               + ", testList="
               + this.testList
               + ", phone="
               + this.phone
               + ", phones="
               + this.phones
               + ", phoneMap="
               + this.phoneMap
               + "]";
    }


}
