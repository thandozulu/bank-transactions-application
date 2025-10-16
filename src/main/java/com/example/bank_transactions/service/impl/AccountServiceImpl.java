package com.example.bank_transactions.service.impl;

import com.example.bank_transactions.dto.AccountDTO;
import com.example.bank_transactions.exception.AccountNotFoundException;
import com.example.bank_transactions.model.Account;
import com.example.bank_transactions.repository.AccountRepository;
import com.example.bank_transactions.service.AccountService;
import com.example.bank_transactions.utility.AccountMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper){
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        Account account = accountMapper.toEntity(accountDTO);
        Account savedAccount = accountRepository.save(account);
        return accountMapper.toDTO(savedAccount);
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        return accountRepository.findAll().stream().map(accountMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public AccountDTO getAccountById(long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account not found"));
        return accountMapper.toDTO(account);
    }

    @Override
    public AccountDTO updateAccount(long id, AccountDTO accountDTO) {
        Account account = accountMapper.toEntity(accountDTO);
        Account updatedAccount = accountRepository.save(account);
        return accountMapper.toDTO(updatedAccount);
    }

    @Override
    public void deleteAccount(long id) {
        accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException("Account not found"));
        accountRepository.deleteById(id);
    }
}
