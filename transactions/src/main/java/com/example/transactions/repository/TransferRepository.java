package com.example.transactions.repository;

import com.example.transactions.entity.TransactionRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends
        JpaRepository<TransactionRecord,Long> {
}
