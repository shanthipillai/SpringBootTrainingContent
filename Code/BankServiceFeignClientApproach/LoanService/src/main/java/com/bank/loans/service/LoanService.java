package com.bank.loans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.loans.model.Loan;
import com.bank.loans.repository.LoanRepository;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository repo;

    public Loan applyLoan(Loan loan) {

        // Simple logic
        loan.setStatus("APPROVED");

        // EMI calculation (basic)
        loan.setEmi(loan.getAmount() / 50);

        return repo.save(loan);
    }

    public List<Loan> getLoansByAccount(int accountId) {
        return repo.findByAccountId(accountId);
    }

    public Loan closeLoan(int loanId) {

        Loan loan = repo.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        loan.setStatus("CLOSED");

        return repo.save(loan);
    }
}