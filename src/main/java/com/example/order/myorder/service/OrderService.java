package com.example.order.myorder.service;

import com.example.order.myorder.entity.Order;
import com.example.order.myorder.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepository;

    public List<Order> allOrders() {
        List<Order> allOrders = new ArrayList<>();
        orderRepository.findAll().forEach(orderx -> {
            System.out.println("read order" + orderx);
            allOrders.add(orderx);
        });

        return allOrders;
    }

    public void saveOrder(Order ordo) {
        orderRepository.save(ordo);
    }

    public void updateOrder(int key, Order orderForUpdate) {
        if (orderRepository.findById(key).isPresent()) {

            Order theOrder = orderRepository.findById(key).get();
            theOrder.setCartId(orderForUpdate.getCartId());
            theOrder.setName(" order updated");
            orderRepository.save(theOrder);

        }
    }


    public void deleteOrder(int key) {
        if (orderRepository.findById(key).isPresent()) {
            System.out.println("order found");
            orderRepository.deleteById(key);
        } else {
            System.out.println("order not found");
        }


    }

}