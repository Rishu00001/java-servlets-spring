package com.example.transactions.controller;

import com.example.transactions.entity.Account;
import com.example.transactions.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/account")
public class AccountController {
    AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }
    @PostMapping
    public ResponseEntity<String> createAccount(
            @RequestBody Account account){
        accountService.createAccount(account);
        return ResponseEntity.status(201).body("Account created");
    }
}
