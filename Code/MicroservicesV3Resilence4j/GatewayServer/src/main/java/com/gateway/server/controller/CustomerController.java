package com.gateway.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gateway.server.dto.CustomerDetails;
import com.gateway.server.service.CustomerService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{userId}")
    public Mono<CustomerDetails> getCustomerDetails(@PathVariable String userId) {
        return customerService.fetchCustomerDetails(userId);
    }
}