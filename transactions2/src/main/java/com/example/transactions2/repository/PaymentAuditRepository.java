package com.example.transactions2.repository;

import com.example.transactions2.entity.PaymentAudit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentAuditRepository
        extends JpaRepository<PaymentAudit, Long> {
}
