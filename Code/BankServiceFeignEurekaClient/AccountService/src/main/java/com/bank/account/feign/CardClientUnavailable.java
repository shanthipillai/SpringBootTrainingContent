package com.bank.account.feign;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bank.account.dto.Card;
@Component
public class CardClientUnavailable implements CardClient {

	@Override
	public List<Card> getCards(int accountId) {
		System.out.println("⚠️ Fallback triggered - Cards service down");
        return List.of();
	}

}
