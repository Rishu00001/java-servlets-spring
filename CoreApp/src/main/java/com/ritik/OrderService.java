package com.ritik;

import com.ritik.notification.EmailService;
import com.ritik.notification.NotificationService;
import com.ritik.notification.SmsService;

public class OrderService {

    //NotificationService notifications = new EmailService();
    NotificationService notifications = null;
    public OrderService(NotificationService notifications){
        this.notifications = notifications;
    }
    public void placeOrder(){
        System.out.println("Order Placed");
        notifications.sendNotification();
    }
}
