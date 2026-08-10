package com.rishu;

import org.springframework.beans.factory.annotation.Qualifier;

public class B {
    private OrderService orderService;

    public B(@Qualifier("getOrder") OrderService orderService){
        this.orderService = orderService;
    }
}
