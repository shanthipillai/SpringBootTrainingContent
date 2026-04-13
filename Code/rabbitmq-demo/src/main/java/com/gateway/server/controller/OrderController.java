package com.gateway.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gateway.server.dto.Order;
import com.gateway.server.service.OrderProducer;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderProducer producer;

    @PostMapping
    public String placeOrder(@RequestBody Order order) {
        producer.sendOrder(order);
        return "Order sent to multiple queues!";
    }
}