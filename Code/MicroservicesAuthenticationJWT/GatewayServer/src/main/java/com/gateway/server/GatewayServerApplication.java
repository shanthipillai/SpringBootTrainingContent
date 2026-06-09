package com.gateway.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableDiscoveryClient
public class GatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
		  BCryptPasswordEncoder encoder =
	                new BCryptPasswordEncoder();

	        String encodedPassword =
	                encoder.encode("admin123");

	        System.out.println(encodedPassword);
	}

}
