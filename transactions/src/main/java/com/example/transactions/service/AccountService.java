package com.example.transactions.service;

import com.example.transactions.entity.Account;
import com.example.transactions.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private AccountRepository accountRepository;
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    public void createAccount(Account account){
        accountRepository.save(account);
    }
}
