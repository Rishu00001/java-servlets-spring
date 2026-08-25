package com.example.transactions2.service;

import com.example.transactions2.entity.Order;
import com.example.transactions2.entity.PaymentAudit;
import com.example.transactions2.repository.PaymentAuditRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentAuditService {
    private PaymentAuditRepository paymentAuditRepository;
    public PaymentAuditService(PaymentAuditRepository paymentAuditRepository){
        this.paymentAuditRepository = paymentAuditRepository;
    }

    @Transactional(
            propagation = Propagation.REQUIRED
    )
    public void createAudit(Order order){
        PaymentAudit paymentAudit = new PaymentAudit(
                order.getPrice(),
                order.getId(),
                true
        );
        paymentAuditRepository.save(paymentAudit);
    }
}
