package com.training.spring.rabbitmq;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "sms-queue", autoDelete = "false", durable = "true"),
                                             exchange = @Exchange(name = "message-exchange",
                                                                  autoDelete = "false",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "sms-message"))
    public void handleSmsMessage(final NotifyMessage str) {
        System.out.println("recieved sms message : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "email-queue",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "message-exchange",
                                                                  autoDelete = "false",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.DIRECT),
                                             key = "email-message"))
    public void handleEmailMessage(final NotifyMessage str) {
        System.out.println("recieved email message : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "sms-topicq",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "message-topic-exchange",
                                                                  autoDelete = "false",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "message.sms.europe.turkey.#"))
    public void handleEuropeTurkeySMSMessage(final NotifyMessage str) {
        System.out.println("recieved EuropeTurkeySMS message : " + str);
    }


    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "all-message-topicq",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "message-topic-exchange",
                                                                  autoDelete = "false",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "message.#"))
    public void handleAllMessage(final NotifyMessage str) {
        System.out.println("recieved All message : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "all-sms-message-topicq",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "message-topic-exchange",
                                                                  autoDelete = "false",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "message.sms.#"))
    @SendTo("message-response-exchange/message-response")
    public NotifyResponse handleALLSMSMessage(final NotifyMessage str) {
        System.out.println("recieved ALLSMS message : " + str);
        NotifyResponse notifyResponseLoc = new NotifyResponse();
        notifyResponseLoc.setResponse("Message successfully sent to : " + str.getDest());
        return notifyResponseLoc;

    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "email-topicq",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "message-topic-exchange",
                                                                  autoDelete = "false",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "message.email.europe.turkey.#"))
    public void handleEuropeTurkeyEMAILMessage(final NotifyMessage str) {
        System.out.println("recieved EuropeTurkeyEMAIL message : " + str);
    }

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "all-email-message-topicq",
                                                            autoDelete = "false",
                                                            durable = "true"),
                                             exchange = @Exchange(name = "message-topic-exchange",
                                                                  autoDelete = "false",
                                                                  durable = "true",
                                                                  type = ExchangeTypes.TOPIC),
                                             key = "message.email.#"))
    public void handleALLEMAILMessage(final NotifyMessage str) {
        System.out.println("recieved ALLEMAIL message : " + str);
    }

}
