package com.gateway.server.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EMAIL_QUEUE = "email_queue";
    public static final String SMS_QUEUE = "sms_queue";

    public static final String EXCHANGE = "order_exchange";

    public static final String EMAIL_ROUTING_KEY = "email_routing";
    public static final String SMS_ROUTING_KEY = "sms_routing";
    public static final String DLQ = "email_dlq";
    public static final String DLX = "dlx_exchange";
    public static final String DLQ_ROUTING_KEY = "dlq_routing";

    
    
    @Bean
    public Queue deadLetterQueue() {
        return new Queue(DLQ);
    }

    @Bean
    public DirectExchange dlxExchange() {
        return new DirectExchange(DLX);
    }

    @Bean
    public Binding dlqBinding() {
        return BindingBuilder
                .bind(deadLetterQueue())
                .to(dlxExchange())
                .with(DLQ_ROUTING_KEY);
    }
    @Bean
    public Queue emailQueue() {

        Map<String, Object> args = new HashMap<>();

        args.put("x-dead-letter-exchange", DLX);
        args.put("x-dead-letter-routing-key", DLQ_ROUTING_KEY);

        return new Queue(EMAIL_QUEUE, true, false, false, args);
    }
    @Bean
    public Queue smsQueue() {
        return new Queue(SMS_QUEUE);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Binding emailBinding() {
        return BindingBuilder
                .bind(emailQueue())
                .to(exchange())
                .with(EMAIL_ROUTING_KEY);
    }

    @Bean
    public Binding smsBinding() {
        return BindingBuilder
                .bind(smsQueue())
                .to(exchange())
                .with(SMS_ROUTING_KEY);
    }

    // 🔥 ADD THIS (VERY IMPORTANT)
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    // 🔥 ADD THIS (VERY IMPORTANT)
    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }
}