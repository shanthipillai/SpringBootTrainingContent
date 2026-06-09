package com.gateway.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.web.bind.annotation.*;

import com.gateway.server.dto.LoginRequest;
import com.gateway.server.security.JwtUtil;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private ReactiveAuthenticationManager authenticationManager;

    @PostMapping("/login")
    public Mono<String> login(
            @RequestBody LoginRequest request) {

        return authenticationManager.authenticate(

                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )

        ).map(authentication -> {

            return JwtUtil.generateToken(
                    request.getUsername());
        });
    }
}