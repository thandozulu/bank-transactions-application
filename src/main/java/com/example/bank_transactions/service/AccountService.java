package com.example.bank_transactions.service;

import com.example.bank_transactions.dto.AccountDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    AccountDTO createAccount(AccountDTO accountDTO);

    List<AccountDTO> getAllAccounts();

    AccountDTO getAccountById(long id);

    AccountDTO updateAccount(long id, AccountDTO accountDTO);

    void deleteAccount(long id);
}
