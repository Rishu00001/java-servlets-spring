package com.rishu;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    @Autowired
    private OrderService os;

//    public PaymentService(OrderService os){
//        this.os = os;
//    }

    public void pay(){
        System.out.println("processing payment...");
       // os.getOrderDetails();  -> this should not be done here
    }
}
