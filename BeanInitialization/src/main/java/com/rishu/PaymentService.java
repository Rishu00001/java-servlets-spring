package com.rishu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class PaymentService {
    OrderService os;

    public PaymentService(OrderService os){
        this.os = os;
    }
    public  void pay(){

        System.out.println("payment successfull");
        os.getDetails();
    }
}
