package com.rishu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    @Autowired
    private PaymentService ps;

//    @Autowired
//    public OrderService(PaymentService ps){
//        this.ps = ps;
//    }

    public void placeOrder(){
        ps.pay();
        getOrderDetails();
        System.out.println("Your order is placed");
    }

    public void getOrderDetails(){
        System.out.println("Order details Fetched");
    }
}
