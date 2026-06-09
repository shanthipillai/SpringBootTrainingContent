package com.gateway.server.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;


@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService service;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    // =====================================================
    // PASSWORD ENCODER
    // =====================================================

    @Bean
    PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    // =====================================================
    // AUTHENTICATION MANAGER
    // =====================================================

    @Bean
    public ReactiveAuthenticationManager authenticationManager(
            PasswordEncoder encoder) {

        UserDetailsRepositoryReactiveAuthenticationManager manager =
                new UserDetailsRepositoryReactiveAuthenticationManager(service);

        manager.setPasswordEncoder(encoder);

        return manager;
    }

    // =====================================================
    // SECURITY FILTER CHAIN
    // =====================================================

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(
            ServerHttpSecurity http) {

        http

            .csrf(csrf -> csrf.disable())

            .authorizeExchange(exchange -> exchange

                .pathMatchers("/auth/**").permitAll()

                .pathMatchers("/actuator/**").permitAll()

                .pathMatchers("/accounts/**").authenticated()

                .pathMatchers("/cards/**").authenticated()

                .pathMatchers("/loans/**").authenticated()

                .pathMatchers("/customer/**").authenticated()

                .anyExchange().authenticated()
            )

            // =====================================================
            // ADD JWT FILTER
            // =====================================================

            .addFilterAt(
                    jwtAuthenticationFilter,
                    SecurityWebFiltersOrder.AUTHENTICATION
            );

        return http.build();
    }
}