package com.bank.cards.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardId;

    private int accountId;

    private String cardNumber;

    private String type; // DEBIT / CREDIT

    private String status; // ACTIVE / BLOCKED
}