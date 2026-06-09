package com.gateway.server.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gateway.server.entity.Customers;

@Repository
public interface CustomerRepository
        extends JpaRepository<Customers,Integer> {

    Optional<Customers> findByUsername(String username);

}