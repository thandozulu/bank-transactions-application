package com.example.bank_transactions.model;

import com.example.bank_transactions.utility.AccountType;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.Currency;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    @Column(nullable = false)
    private String accountHolder;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @NotNull
    @DecimalMin(value = "0.0")
    @Column(nullable = false)
    private BigDecimal balance;

    @NotNull
    private Currency currency;

}
