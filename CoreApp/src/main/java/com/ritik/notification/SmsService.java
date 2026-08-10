package com.ritik.notification;

public class SmsService implements NotificationService {
    @Override
    public void sendNotification(){
        System.out.println("SMS Notification sent");
    }
}
