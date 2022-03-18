package com.training.spring.order.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.integration.person.PersonClient;
import com.training.spring.order.rest.models.OrderRest;

@Service
public class OrderManagementService {

    @Autowired
    private PersonClient pc;

    public String place(final OrderRest orderRestParam) {
        Long personId = this.pc.getPersonByPhoneNumber(orderRestParam.getPhone());
        if (personId == null) {
            personId = this.pc.activatePerson(orderRestParam);
        }
        if (personId == null) {
            throw new IllegalStateException("Can not create new person");
        }

        return "Person : " + personId + " created and activated";
    }

}
