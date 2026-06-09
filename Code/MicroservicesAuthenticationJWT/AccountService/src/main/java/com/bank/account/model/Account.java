package com.bank.account.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int accountId;

    private String userId;

    private double balance;

    private String status; // ACTIVE / BLOCKED
}