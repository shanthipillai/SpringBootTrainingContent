package com.bank.loans.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.loans.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer> {

    List<Loan> findByAccountId(int accountId);
}