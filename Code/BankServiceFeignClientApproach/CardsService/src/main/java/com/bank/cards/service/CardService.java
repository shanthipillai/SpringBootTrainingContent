package com.bank.cards.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.cards.model.Card;
import com.bank.cards.repository.CardRepository;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository repo;

    public Card issueCard(Card card) {

        // Generate dummy card number
        card.setCardNumber("1234-5678-" + System.currentTimeMillis());

        card.setStatus("ACTIVE");

        return repo.save(card);
    }

    public List<Card> getCardsByAccount(int accountId) {
        return repo.findByAccountId(accountId);
    }

    public Card blockCard(int cardId) {

        Card card = repo.findById(cardId)
                .orElseThrow(() -> new RuntimeException("Card not found"));

        card.setStatus("BLOCKED");

        return repo.save(card);
    }

    public Card activateCard(int cardId) {

        Card card = repo.findById(cardId)
                .orElseThrow(() -> new RuntimeException("Card not found"));

        card.setStatus("ACTIVE");

        return repo.save(card);
    }
}