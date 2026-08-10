package com.rishu;

import org.springframework.beans.factory.annotation.Qualifier;

public class A {
    private  OrderService orderService;
    public A( @Qualifier("getOrder2") OrderService orderService){
        this.orderService = orderService;
    }
}
