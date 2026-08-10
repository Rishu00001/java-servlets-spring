package com.ritik.payment;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Qualifier
public class UpiPayment implements PaymentService{

    @Override
    public void makePayment(){
        System.out.println("Paid via UPI");
    }
}
