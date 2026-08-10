package com.rishu;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class CartService /*implements InitializingBean*/ implements BeanNameAware , ApplicationContextAware {
    Map<Integer,String> mp;
    public CartService(){
        mp = new HashMap<>();
        System.out.println("CartService constructor called");
    }
    @PostConstruct
    public void start(){
        System.out.println("Initialization callback");
        mp.put(1,"Ritik");
        mp.put(2,"Shivam");
    }
    @Override
    public void setBeanName(String name) {
        System.out.println(name);
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(applicationContext );
    }
    public void addToCart(){
        System.out.println("Added to cart");
    }
    public String getValue(int key){
        return mp.get(key);
    }
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("Initialization callback");
//        mp.put(1,"Ritik");
//        mp.put(2,"Shivam");
    //    }
}
