package com.example.bank_transactions.config;

import com.example.bank_transactions.dto.AccountDTO;
import com.example.bank_transactions.service.AccountService;
import com.example.bank_transactions.utility.AccountType;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Currency;

@Component
@RequiredArgsConstructor
public class DataSeeder {

    private final AccountService accountService;

    @PostConstruct
    public void seedAccounts() {
        // Check if accounts already exist to avoid duplicates
        if (accountService.getAllAccounts().isEmpty()) {
            accountService.createAccount(AccountDTO.builder()
                    .accountHolderName("Alice Johnson")
                    .accountType(AccountType.SAVINGS)
                    .balance(BigDecimal.valueOf(1000))
                    .currency(Currency.getInstance("USD"))
                    .build());

            accountService.createAccount(AccountDTO.builder()
                    .accountHolderName("Bob Smith")
                    .accountType(AccountType.CURRENT)
                    .balance(BigDecimal.valueOf(2500))
                    .currency(Currency.getInstance("EUR"))
                    .build());

            accountService.createAccount(AccountDTO.builder()
                    .accountHolderName("Charlie Brown")
                    .accountType(AccountType.SAVINGS)
                    .balance(BigDecimal.valueOf(500))
                    .currency(Currency.getInstance("ZAR"))
                    .build());
        }
    }
}
