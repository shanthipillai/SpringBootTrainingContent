package com.gateway.server.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.gateway.server.config.RabbitMQConfig;
import com.gateway.server.dto.Order;

//@Service
public class SmsConsumer {

    @RabbitListener(queues = RabbitMQConfig.SMS_QUEUE)
    public void consume(Order order) {
        System.out.println("📱 SMS sent for order: " + order.getOrderId());
    }
}