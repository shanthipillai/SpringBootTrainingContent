package com.bank.account.controller;

import com.bank.account.dto.AccountSummary;
import com.bank.account.model.Account;
import com.bank.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService service;
  
    // Create Account
    @PostMapping
    public Account create(@RequestBody Account acc) {
        return service.createAccount(acc);
    }

    // Get by userId
    @GetMapping("/user/{userId}")
    public Account getByUserId(@PathVariable String userId) {
        return service.getByUserId(userId);
    }

    // Debit
    @PostMapping("/debit")
    public Account debit(@RequestParam int accountId,
                         @RequestParam double amount) {
        return service.debit(accountId, amount);
    }

    // Credit
    @PostMapping("/credit")
    public Account credit(@RequestParam int accountId,
                          @RequestParam double amount) {
        return service.credit(accountId, amount);
    }
	
	  @GetMapping("/full/{userId}") public AccountSummary
	  getFullDetails(@PathVariable String userId) throws Exception { return
	  service.getFullDetails(userId); }
	 
}