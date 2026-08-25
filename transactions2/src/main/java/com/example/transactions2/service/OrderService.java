package com.example.transactions2.service;

import com.example.transactions2.entity.Order;
import com.example.transactions2.repository.OrderRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    private PaymentAuditService paymentAuditService;
    private OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository,
                        PaymentAuditService paymentAuditService){
        this.orderRepository = orderRepository;
        this.paymentAuditService = paymentAuditService;
    }

    @Transactional()
    public void placeOrder(Order order){
        orderRepository.save(order);
        paymentAuditService.createAudit(order);

        //Exception occurs
        throw new RuntimeException("Error occurred");
    }
}
