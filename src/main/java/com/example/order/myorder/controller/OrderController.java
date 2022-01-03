package com.example.order.myorder.controller;

import com.example.order.myorder.entity.Order;
import com.example.order.myorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController

@RequestMapping(value = "/orders", method = RequestMethod.GET, produces = "application/json")
public class OrderController {

    @Autowired
    private OrderService orderService;

    public static Map<String, Object> putJsonDocument(Order order) {

        Map<String, Object> jsonDocument = new HashMap<String, Object>();

        jsonDocument.put("name", order.getName());
        jsonDocument.put("userId", order.getUserId());
        jsonDocument.put("cartId", order.getCartId());
        jsonDocument.put("productId", order.getProductId());
        jsonDocument.put("quantity", order.getQuantity());
        jsonDocument.put("price", order.getPrice());

        return jsonDocument;
    }

    @GetMapping("/alldata")
    public ResponseEntity<List<Order>> allOrders() {


        List<Order> allOrders = orderService.allOrders();
        System.out.println("Order - List -size" + orderService.allOrders().size());
        return new ResponseEntity<List<Order>>(allOrders, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public ResponseEntity<String> postDriver(@RequestBody Order order) {
        orderService.saveOrder(order);
        return new ResponseEntity<String>("Saved successfully", HttpStatus.OK);
    }

    @GetMapping("/init")
    public String initData() {
        Order morder = new Order(1001, "1", "1", "SampleName", "A" + UUID.randomUUID(), 12, 10, null, null);

        orderService.saveOrder(morder);

        return "sample data saved  ";
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/orders/{id}")
    public ResponseEntity<String> putDriver(@PathVariable("id") String id, @RequestBody Order orderForUpdate) {
        orderService.updateOrder(Integer.parseInt(id), orderForUpdate);
        return new ResponseEntity<String>("update is successfull", HttpStatus.OK);
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable final String id) {

        orderService.deleteOrder(Integer.parseInt(id));
        return "order-deleted";
    }


}
