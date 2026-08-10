package com.rishu;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

//@Component("user")
public class UserService implements BeanNameAware {
    public UserService(){
        System.out.println("UserService constructor called");
    }
    @Override
    public void setBeanName(String name){
        System.out.println("Bean name is "+name);
    }
}
