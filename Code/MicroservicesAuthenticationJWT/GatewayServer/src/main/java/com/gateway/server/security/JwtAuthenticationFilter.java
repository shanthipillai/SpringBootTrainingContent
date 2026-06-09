package com.gateway.server.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import reactor.core.publisher.Mono;

@Component
public class JwtAuthenticationFilter
        implements WebFilter {

    @Autowired
    private CustomUserDetailsService service;

    @Override
    public Mono<Void> filter(
            ServerWebExchange exchange,
            WebFilterChain chain) {

        // =====================================================
        // READ AUTHORIZATION HEADER
        // =====================================================

        String authHeader =
                exchange.getRequest()
                        .getHeaders()
                        .getFirst("Authorization");

        // =====================================================
        // CHECK HEADER EXISTS
        // =====================================================

        if(authHeader != null &&
                authHeader.startsWith("Bearer ")) {

            // =====================================================
            // EXTRACT TOKEN
            // =====================================================

            String token =
                    authHeader.substring(7);

            // =====================================================
            // VALIDATE TOKEN
            // =====================================================

            if(JwtUtil.validateToken(token)) {

                // =====================================================
                // EXTRACT USERNAME
                // =====================================================

                String username =
                        JwtUtil.extractUsername(token);

                // =====================================================
                // LOAD USER FROM DB
                // =====================================================

                return service.findByUsername(username)

                        .flatMap(userDetails -> {

                            // =====================================================
                            // CREATE AUTHENTICATION OBJECT
                            // =====================================================

                            UsernamePasswordAuthenticationToken auth =
                                    new UsernamePasswordAuthenticationToken(
                                            userDetails,
                                            null,
                                            userDetails.getAuthorities()
                                    );

                            // =====================================================
                            // CREATE SECURITY CONTEXT
                            // =====================================================

                            SecurityContextImpl securityContext =
                                    new SecurityContextImpl(auth);

                            // =====================================================
                            // SET SECURITY CONTEXT
                            // =====================================================

                            return chain.filter(exchange)

                                    .contextWrite(
                                            ReactiveSecurityContextHolder
                                                    .withSecurityContext(
                                                            Mono.just(securityContext)
                                                    )
                                    );
                        });
            }
        }

        // =====================================================
        // CONTINUE FILTER CHAIN
        // =====================================================

        return chain.filter(exchange);
    }
}