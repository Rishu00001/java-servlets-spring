package com.rishu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfig {
    @Bean
    public OrderService getOrder(){
        System.out.println("Created from getOrder");
        return new OrderService();
    }

    @Bean
    public OrderService getOrder2(){
        System.out.println("Created from getOrder2");
        return new OrderService();
    }
}
