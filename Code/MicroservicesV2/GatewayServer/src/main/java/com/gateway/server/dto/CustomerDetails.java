package com.gateway.server.dto;

import java.util.List;

public class CustomerDetails {

    private Account account;
    private List<Card> cards;
    private List<Loan> loans;
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public List<Card> getCards() {
		return cards;
	}
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	public List<Loan> getLoans() {
		return loans;
	}
	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

    // getters & setters
    
}