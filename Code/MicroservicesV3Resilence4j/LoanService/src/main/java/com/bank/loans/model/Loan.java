package com.bank.loans.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanId;

    private int accountId;

    private double amount;

    private double emi;

    private String status; // APPROVED / REJECTED / CLOSED
}