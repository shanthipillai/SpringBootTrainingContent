package com.bank.account.dto;


import java.util.List;

import com.bank.account.model.Account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountSummary {

    private Account account;
    private List<Card> cards;
    private List<Loan> loans;
}