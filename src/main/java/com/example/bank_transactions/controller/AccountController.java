package com.example.bank_transactions.controller;

import com.example.bank_transactions.dto.AccountDTO;
import com.example.bank_transactions.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;

@RestController
@RequestMapping("api/v1/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDTO> createAccount(@Valid @RequestBody AccountDTO accountDTO){
        return ResponseEntity.ok(accountService.createAccount(accountDTO));
    }

    @GetMapping
    public ResponseEntity<AccountDTO> getAccount(@RequestParam long id){
        return ResponseEntity.ok(accountService.getAccountById(id));
    }
}
