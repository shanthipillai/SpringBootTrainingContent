package com.bank.loans.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.*;

import com.bank.loans.model.Loan;
import com.bank.loans.service.LoanService;

import java.util.List;

@RestController

@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService service;
   
    // Apply Loan
    @PostMapping
    public Loan apply(@RequestBody Loan loan) {
        return service.applyLoan(loan);
    }

    // Get loans by accountId
    @GetMapping("/account/{accountId}")
    public List<Loan> getLoans(@PathVariable int accountId) {
    	System.out.println("In Loean Service"+Thread.currentThread().getName());
        return service.getLoansByAccount(accountId);
    }

    // Close loan
    @PutMapping("/{loanId}/close")
    public Loan close(@PathVariable int loanId) {
        return service.closeLoan(loanId);
    }
}