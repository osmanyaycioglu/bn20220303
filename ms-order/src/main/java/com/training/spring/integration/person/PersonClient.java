package com.training.spring.integration.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.training.spring.integration.person.models.PersonRest;
import com.training.spring.order.rest.models.OrderRest;

@Service
public class PersonClient {

    @Autowired
    private RestTemplate restTemplate;

    public Long getPersonByPhoneNumber(final String phoneParam) {
        Long personId = this.restTemplate.getForObject("http://PERSON/api/v1/person/info/query/get/id/by/phone?phone="
                                                       + phoneParam,
                                                       Long.class);
        return personId;
    }

    public Long activatePerson(final OrderRest orderRestParam) {
        PersonRest personRestLoc = new PersonRest();
        personRestLoc.setName(orderRestParam.getName());
        personRestLoc.setSurname(orderRestParam.getSurname());
        personRestLoc.setPhone(orderRestParam.getPhone());
        Long personId = this.restTemplate.postForObject("http://PERSON/api/v1/person/provision/activate",
                                                        personRestLoc,
                                                        Long.class);
        return personId;

    }

}
