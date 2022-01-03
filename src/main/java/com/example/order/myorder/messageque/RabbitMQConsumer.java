package com.example.order.myorder.messageque;

import com.example.order.myorder.entity.Cart;
import com.example.order.myorder.entity.Order;
import com.example.order.myorder.repository.OrderRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class RabbitMQConsumer {

    @Autowired
    private OrderRepo orderRepo;

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = "card-queue")
    public void recievedMessage(Cart mycard) throws Exception {
        logger.info("Recieved Message From RabbitMQ: " + mycard.getProductName());
        int sayi = (int) (Math.random() * 180200);
        Order incomingOrder = new Order();
        incomingOrder.setOrderId(sayi);
        incomingOrder.setCartId(mycard.getCartId() + "");
        incomingOrder.setProductId(mycard.getProductId() + "");
        incomingOrder.setPrice(mycard.getPrice());
        incomingOrder.setName(mycard.getProductName());
        incomingOrder.setCreationDate(new Date());
        incomingOrder.setQuantity(mycard.getQuantity());
        incomingOrder.setUserId(mycard.getCustomerId() + "");
        orderRepo.save(incomingOrder);

    }
}

