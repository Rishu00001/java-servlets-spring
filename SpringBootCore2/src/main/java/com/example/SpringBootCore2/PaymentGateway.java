package com.example.SpringBootCore2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PaymentGateway {

    private PaymentProperties paymentProperties;


    public PaymentGateway(PaymentProperties paymentProperties){
        this.paymentProperties = paymentProperties;
    }
    public  String getType(){
        return paymentProperties.getType();
    }
    public int getRetryCount(){
        return paymentProperties.getRetryCount();
    }
    public int getTimeout(){
        return paymentProperties.getTimeout();
    }
    public boolean isEnabled(){
        return paymentProperties.isEnabled();
    }
    public void print(){

        System.out.println(getType());
        System.out.println(getRetryCount());
    }
}

