package com.bank.cards.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.cards.model.Card;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Integer> {

    List<Card> findByAccountId(int accountId);
}