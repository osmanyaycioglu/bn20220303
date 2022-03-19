package com.training.spring.order.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.spring.integration.person.PersonClient;
import com.training.spring.integration.restaurant.RestaurantMenuClient;
import com.training.spring.integration.sms.NotifyMessage;
import com.training.spring.order.rest.models.OrderRest;

@Service
public class OrderManagementService {

    @Autowired
    private PersonClient         pc;

    @Autowired
    private RestaurantMenuClient rmc;

    @Autowired
    private RabbitTemplate       rabbitTemplate;

    public String place(final OrderRest orderRestParam) {
        Long personId = this.pc.getPersonByPhoneNumber(orderRestParam.getPhone());
        if (personId == null) {
            personId = this.pc.activatePerson(orderRestParam);
        }
        if (personId == null) {
            throw new IllegalStateException("Can not create new person");
        }
        Long priceLoc = this.rmc.getPrice(orderRestParam,
                                          personId);
        NotifyMessage messageLoc = new NotifyMessage();
        messageLoc.setDest(orderRestParam.getPhone());
        messageLoc.setMessage("Siparişinizin tutarı : " + priceLoc);
        this.rabbitTemplate.convertAndSend("message-topic-exchange",
                                           "message.sms.europe.turkey.restaurant",
                                           messageLoc);
        return "Person : " + personId + " meals price is : " + priceLoc;
    }

}
