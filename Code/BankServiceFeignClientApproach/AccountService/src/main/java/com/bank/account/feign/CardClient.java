package com.bank.account.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bank.account.dto.Card;


@FeignClient(name="card-service", url = "http://localhost:8081",  fallback = CardClientUnavailable.class)
public interface CardClient {
	@GetMapping("/cards/account/{accountId}")
	  public List<Card> getCards(@PathVariable int accountId);
}
