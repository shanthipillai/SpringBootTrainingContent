package com.webclient.fetch.product.details.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.webclient.fetch.product.details.dto.Product;
import com.webclient.fetch.product.details.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all-products")
    public Flux<Product> getAllProducts() {
        return productService.getProducts();
    }
    
    @GetMapping("/products/{id}")
    public Mono<Product> getProduct(@PathVariable("id")  int id) {

        return productService.getProductById(id);
    }
  
}