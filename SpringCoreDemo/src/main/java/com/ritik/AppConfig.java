package com.ritik;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.ritik")
public class AppConfig {

    @Bean
    public User createUser(){
        return new User("Adtiya",28);
    }
}
