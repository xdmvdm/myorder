package com.example.demoelastic;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepository;

    public List<Order> allOrders() {
        List<Order> allOrders = new ArrayList<>();


        orderRepository.findAll().forEach(orderx -> {
            System.out.println("read order(x)" + orderx);
            allOrders.add(orderx);
        });

        return allOrders;
    }

    public void saveOrder(Order ordo) {
        orderRepository.save(ordo);
    }

    public void updateDriver(String key, Order orderForUpdate) {
        if (orderRepository.findById(key).isPresent()) {

            Order bulunan = orderRepository.findById(key).get();
            bulunan.setCartId(orderForUpdate.getCartId());
            bulunan.setName(" order updated");
            orderRepository.save(bulunan);


        }
    }


    public void deleteOrder(String key) {
        if (orderRepository.findById(key).isPresent()) {
            System.out.println("order found");
            orderRepository.deleteById(key);
        } else {
            System.out.println("order not found");
        }


    }

}