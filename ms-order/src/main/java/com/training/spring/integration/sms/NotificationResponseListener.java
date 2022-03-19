package com.training.spring.integration.sms;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class NotificationResponseListener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "response-queue",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "message-response-exchange",
                                                                  autoDelete = "false",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "message-response"))
    public void handleResponseMessage(final NotifyResponse resp) {
        System.out.println("recieved response : " + resp);
    }

}
