package com.gateway.server.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.gateway.server.config.RabbitMQConfig;
import com.gateway.server.dto.Order;

@Service
public class EmailConsumer {

	/*
	 * @RabbitListener(queues = RabbitMQConfig.EMAIL_QUEUE) public void
	 * consume(Order order) { System.out.println("📧 Email sent for order: " +
	 * order.getOrderId()); }
	 */
	
	
	@RabbitListener(queues = RabbitMQConfig.EMAIL_QUEUE)
	public void consume(Order order) {

	    System.out.println("Processing: " + order.getOrderId());

	    if (order.getPrice() > 50000) {
	        throw new RuntimeException("Simulated failure ❌");
	    }

	    System.out.println("Success ✅");
	}
	
	
	/*
	 * @RabbitListener(queues = RabbitMQConfig.DLQ) public void processDLQ(Order
	 * order) {
	 * 
	 * System.out.println("❌ Permanently Failed: " + order.getOrderId());
	 * 
	 * // Save to DB / File }
	 */
}