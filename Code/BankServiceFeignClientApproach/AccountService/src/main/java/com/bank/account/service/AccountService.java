package com.bank.account.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.account.dto.AccountSummary;
import com.bank.account.dto.Card;
import com.bank.account.dto.Loan;
import com.bank.account.feign.CardClient;
import com.bank.account.feign.LoanClient;
import com.bank.account.model.Account;
import com.bank.account.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repo;

	@Autowired
	private CardClient cardclient;
	@Autowired
	private LoanClient loanclient;

	// ================= GET BY USER =================
	public Account getByUserId(String userId) {
		return repo.findByUserId(userId).orElseThrow(() -> new RuntimeException("Account not found"));
	}

	// ================= DEBIT =================
	public Account debit(int accountId, double amount) {

		Account acc = repo.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));

		if (acc.getBalance() < amount) {
			throw new RuntimeException("Insufficient balance");
		}

		acc.setBalance(acc.getBalance() - amount);
		return repo.save(acc);
	}

	// ================= CREDIT =================
	public Account credit(int accountId, double amount) {

		Account acc = repo.findById(accountId).orElseThrow(() -> new RuntimeException("Account not found"));

		acc.setBalance(acc.getBalance() + amount);
		return repo.save(acc);
	}

	
	  
	/*
	 * public AccountSummary getFullDetails(String userId) {
	 * 
	 * // Step 1: Get Account Account account = repo.findByUserId(userId).get();
	 * 
	 * // Step 2: Call Cards Service List<Card> cards =
	 * cardclient.getCards(account.getAccountId());
	 * 
	 * // Step 3: Call Loans Service List<Loan> loans =
	 * loanclient.getLoans(account.getAccountId());
	 * 
	 * // Step 4: Aggregate return new AccountSummary(account, cards, loans);
	 * 
	 * }
	 */
	 
	public AccountSummary getFullDetails(String userId) {

		long startTime = System.currentTimeMillis();
		System.out.println("🚀 START - Thread: " + Thread.currentThread().getName());

		// Step 1: Get Account
		Account account = repo.findByUserId(userId).get();
		System.out.println("📦 Account fetched - Thread: " + Thread.currentThread().getName());

		// Step 2: Call Cards Service
		long cardsStart = System.currentTimeMillis();
		System.out.println("💳 Calling Cards Service - Thread: " + Thread.currentThread().getName());

		List<Card> cards = cardclient.getCards(account.getAccountId());

		long cardsEnd = System.currentTimeMillis();
		System.out.println("✅ Cards Response - Time: " + (cardsEnd - cardsStart) + " ms | Thread: "
				+ Thread.currentThread().getName());

		// Step 3: Call Loans Service
		long loansStart = System.currentTimeMillis();
		System.out.println("🏦 Calling Loans Service - Thread: " + Thread.currentThread().getName());

		List<Loan> loans = loanclient.getLoans(account.getAccountId());

		long loansEnd = System.currentTimeMillis();
		System.out.println("✅ Loans Response - Time: " + (loansEnd - loansStart) + " ms | Thread: "
				+ Thread.currentThread().getName());

		long endTime = System.currentTimeMillis();

		System.out.println(
				"🏁 END - Total Time: " + (endTime - startTime) + " ms | Thread: " + Thread.currentThread().getName());

		return new AccountSummary(account, cards, loans);
	}

	// ================= CREATE ACCOUNT =================
	public Account createAccount(Account acc) {
		return repo.save(acc);
	}
}