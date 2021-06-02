package com.example.demoelastic;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Document(indexName = "orderindex")
public class Order {
    @Id
    private String orderId;
    private String userId;
    private String cartId;
    private String productId;
    private String name;
    private int quantity;
    private double price;

    private Date creationDate = new Date();
    private Map<String, String> orderSettings = new HashMap<>();

    public Order(String orderId, String userId, String cartId, String productId, String name, int quantity, double price, Date creationDate, Map<String, String> orderSettings) {
        this.orderId = orderId;
        this.userId = userId;
        this.cartId = cartId;
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.creationDate = creationDate;
        this.orderSettings = orderSettings;
    }

    public Order() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Map<String, String> getOrderSettings() {
        return orderSettings;
    }

    public void setOrderSettings(Map<String, String> orderSettings) {
        this.orderSettings = orderSettings;
    }
}
