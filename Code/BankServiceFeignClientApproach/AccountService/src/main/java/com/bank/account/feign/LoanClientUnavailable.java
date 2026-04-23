package com.bank.account.feign;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bank.account.dto.Loan;
@Component
public class LoanClientUnavailable implements LoanClient{

	@Override
	public List<Loan> getLoans(int accountId) {
	System.out.println("Loan Client is currently unavailable");
		return List.of();
	}

}
