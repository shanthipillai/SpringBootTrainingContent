package com.bank.account.dto;

import lombok.Data;

@Data
public class Card {
    private int cardId;
    private int accountId;
    private String type;
    private String status;
}