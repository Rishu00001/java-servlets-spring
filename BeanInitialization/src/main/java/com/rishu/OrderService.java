package com.rishu;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    PaymentService ps;

    public OrderService(@Lazy PaymentService ps){
        this.ps = ps;
    }
    public void placeOrder(){
        ps.pay();
        System.out.println("Order Placed");
    }
    public void getDetails(){
        System.out.println("Fetching details.....");
    }
}
