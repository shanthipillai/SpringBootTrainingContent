package com.bank.account.dto;

import lombok.Data;

@Data
public class Loan {
    private int loanId;
    private int accountId;
    private double amount;
    private double emi;
    private String status;
}