package com.ritik.notification;

public class PopupService implements NotificationService {
    @Override
    public void sendNotification(){
        System.out.println("Popup Notification sent");
    }
}
