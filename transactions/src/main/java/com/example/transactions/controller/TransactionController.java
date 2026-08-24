package com.example.transactions.controller;

import com.example.transactions.entity.TransactionRecord;
import com.example.transactions.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/transfer")
public class TransactionController {
    private TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<String> transferAmount(
            @RequestBody TransactionRecord transactionRecord){
        transactionService.transfer(
                transactionRecord.getFromAccountId(),
                transactionRecord.getToAccountId(),
                transactionRecord.getAmount()
        );
        return ResponseEntity.ok("Amount transferred successfully");
    }
}
