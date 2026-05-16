package com.gateway.server.dto;

import java.time.LocalDate;



public class Loan {

    private int loanId;
    private int accountId;
    private double amount;
    private double emi;
    private String status;

    public Loan() {}

    public int getLoanId() { return loanId; }
    public void setLoanId(int loanId) { this.loanId = loanId; }

    public int getAccountId() { return accountId; }
    public void setAccountId(int accountId) { this.accountId = accountId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public double getEmi() { return emi; }
    public void setEmi(double emi) { this.emi = emi; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}