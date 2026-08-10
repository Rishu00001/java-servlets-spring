package com.ritik.notification;

public class EmailService implements NotificationService {
    @Override
    public void sendNotification(){
        System.out.println("Email notif sent");
    }
}
