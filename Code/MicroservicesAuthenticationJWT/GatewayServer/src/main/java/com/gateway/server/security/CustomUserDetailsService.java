package com.gateway.server.security;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.gateway.server.repo.CustomerRepository;
import com.gateway.server.entity.Customers;
import reactor.core.publisher.Mono;
@Service
public class CustomUserDetailsService
        implements ReactiveUserDetailsService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Mono<UserDetails> findByUsername(String username) {

        java.util.Optional<Customers> optionalCustomer =
                repository.findByUsername(username);

        if(optionalCustomer.isPresent()) {

            Customers customer = optionalCustomer.get();

            UserDetails userDetails =
                    User.builder()
                        .username(customer.getUsername())
                        .password(customer.getPassword())
                        .roles(customer.getRole())
                       
                        
                        .build();

            return Mono.just(userDetails);
        }

        return Mono.empty();
    }
}