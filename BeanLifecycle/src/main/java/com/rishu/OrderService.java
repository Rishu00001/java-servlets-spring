package com.rishu;

import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private PaymentService ps;

    public OrderService(PaymentService ps){
        this.ps = ps;
    }

    public void placeOrder(){
        System.out.println("Order Placed");
        ps.pay();
    }
}
