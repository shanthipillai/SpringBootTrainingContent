package com.gateway.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gateway.server.dto.Account;
import com.gateway.server.dto.Card;
import com.gateway.server.dto.CustomerDetails;
import com.gateway.server.dto.Loan;

import reactor.core.publisher.Mono;

@Service
public class CustomerService {

    @Autowired
    private CustomerIntegrationService integrationService;

    public Mono<CustomerDetails> fetchCustomerDetails(String userId) {

        long startTime = System.currentTimeMillis();

        System.out.println("🚀 Entry Thread : "
                + Thread.currentThread().getName());

        // =====================================================
        // ACCOUNT SERVICE CALL
        // =====================================================

        Mono<Account> accountMono =
                integrationService
                        .getAccount(userId)
                        .cache();

        // =====================================================
        // CARD SERVICE CALL
        // =====================================================

        Mono<List<Card>> cardsMono =
                accountMono.flatMap(account -> {

                    System.out.println(
                            "➡️ Inside cards flatMap | Thread : "
                                    + Thread.currentThread().getName());

                    return integrationService
                            .getCards(account.getAccountId());
                });

        // =====================================================
        // LOAN SERVICE CALL
        // =====================================================

        Mono<List<Loan>> loansMono =
                accountMono.flatMap(account -> {

                    System.out.println(
                            "➡️ Inside loans flatMap | Thread : "
                                    + Thread.currentThread().getName());

                    return integrationService
                            .getLoans(account.getAccountId());
                });

        // =====================================================
        // COMBINE ALL RESPONSES
        // =====================================================

        return Mono.zip(accountMono, cardsMono, loansMono)

                .map(tuple -> {

                    System.out.println(
                            "🧠 Mapping Response | Thread : "
                                    + Thread.currentThread().getName());

                    CustomerDetails details =
                            new CustomerDetails();

                    details.setAccount(tuple.getT1());
                    details.setCards(tuple.getT2());
                    details.setLoans(tuple.getT3());

                    return details;
                })

                .doOnSuccess(result -> {

                    long endTime =
                            System.currentTimeMillis();

                    System.out.println(
                            "✅ Total Time Taken : "
                                    + (endTime - startTime)
                                    + " ms");

                    System.out.println(
                            "🏁 Final Thread : "
                                    + Thread.currentThread().getName());
                });
    }
}