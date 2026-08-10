package com.ritik.payment;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier
public class CardPayment implements  PaymentService{
    @Override
    public void makePayment(){
        System.out.println("Card Payment done");
    }
}
