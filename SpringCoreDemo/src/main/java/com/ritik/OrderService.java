package com.ritik;

import com.ritik.payment.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    //@Autowired
    private PaymentService payment = null;

    //@Autowired
    public OrderService(@Qualifier("cardPayment") PaymentService payment){
        this.payment = payment;
    }

//    @Autowired
//    public  void setPaymentService(PaymentService p){
//        payment = p;
//    }

    public void placeOrder(){
        payment.makePayment();
        System.out.println("Order Placed");

    }
}
