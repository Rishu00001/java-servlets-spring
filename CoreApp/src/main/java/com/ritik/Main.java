package com.ritik;

import com.ritik.notification.EmailService;
import com.ritik.notification.NotificationService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        NotificationService notification = new EmailService();


        OrderService order = new OrderService(notification);
        order.placeOrder();
    }
}