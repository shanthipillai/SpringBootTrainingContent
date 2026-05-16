package com.webclient.fetch.product.details.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.webclient.fetch.product.details.dto.Product;
import com.webclient.fetch.product.details.dto.ProductResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ProductService {

    private final WebClient webClient;

    public ProductService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<Product> getProducts() {

        return webClient.get()
                .uri("/products")
                .retrieve()
                .bodyToMono(ProductResponse.class)
                .flatMapMany(response ->
                        Flux.fromIterable(response.getProducts()));
    }
    public Mono<Product> getProductById(int id) {

        return webClient.get()
                .uri("/products/{id}", id)
                .retrieve()
                .bodyToMono(Product.class);
    }
   
}