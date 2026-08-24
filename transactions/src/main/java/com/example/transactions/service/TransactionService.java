package com.example.transactions.service;

import com.example.transactions.entity.Account;
import com.example.transactions.entity.TransactionRecord;
import com.example.transactions.repository.AccountRepository;
import com.example.transactions.repository.TransferRepository;
import jakarta.transaction.Transactional;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class TransactionService {
    private AccountRepository accountRepository;
    private TransferRepository transferRepository;
    public TransactionService(AccountRepository accountRepository,
                              TransferRepository transferRepository){
        this.accountRepository = accountRepository;
        this.transferRepository = transferRepository;
    }
    @Transactional
    public void transfer(Long fromId,
                         Long toId,
                         BigDecimal amount){
        Account fromAccount = accountRepository.findById(fromId)
                .orElseThrow(
                        ()->new RuntimeException("Account not found")
                );
        Account toAccount = accountRepository.findById(toId)
                .orElseThrow(
                        ()->new RuntimeException("Account not found")
                );
        fromAccount.debitAccount(amount);
        toAccount.creditAccount(amount);

        transferRepository.save
                (new TransactionRecord(fromId,toId,amount, LocalDateTime.now()));
        throw new RuntimeException("Error occured");
    }
}
