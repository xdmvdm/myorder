package com.example.order.myorder.repository;

import com.example.order.myorder.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}