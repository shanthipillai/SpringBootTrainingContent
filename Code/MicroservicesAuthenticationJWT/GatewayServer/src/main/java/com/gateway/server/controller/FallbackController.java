package com.gateway.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @GetMapping("/fallback/account")
    public Mono<String> accountFallback() {
        return Mono.just("⚠️ Account Service is down!");
    }

    @GetMapping("/fallback/card")
    public Mono<String> cardFallback() {
        return Mono.just("⚠️ Card Service is down!");
    }

    @GetMapping("/fallback/loan")
    public Mono<String> loanFallback() {
        return Mono.just("⚠️ Loan Service is down!");
    }
}