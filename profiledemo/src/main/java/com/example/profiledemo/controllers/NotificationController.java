package com.example.profiledemo.controllers;

import com.example.profiledemo.services.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/notification")
public class NotificationController {
    private NotificationService notificationService;
    public NotificationController(NotificationService notificationService){
        this.notificationService = notificationService;
    }
    @PostMapping
    public ResponseEntity<String> sendNotification(){
            String response = notificationService.send();
            return ResponseEntity.ok(response);
    }
}
