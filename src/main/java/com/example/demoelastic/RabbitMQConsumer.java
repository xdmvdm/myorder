package com.example.demoelastic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class RabbitMQConsumer {

    @Autowired
    private OrderService orderService;

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = "card-queue", containerFactory = "jsaFactory")
    public void recievedMessage(Cart mycard) throws Exception {
        logger.info("Recieved Message From RabbitMQ: " + mycard.getProductName());
        Order incomingOrder = new Order();
        incomingOrder.setOrderId(UUID.randomUUID() + "");
        incomingOrder.setCartId(mycard.getCartId() + "");
        incomingOrder.setProductId(mycard.getProductId() + "");
        incomingOrder.setPrice(mycard.getPrice());
        incomingOrder.setName(mycard.getProductName());
        incomingOrder.setCreationDate(new Date());
        incomingOrder.setQuantity(mycard.getQuantity());
        incomingOrder.setUserId(mycard.getCustomerId() + "");
        orderService.saveOrder(incomingOrder);

    }
}

//