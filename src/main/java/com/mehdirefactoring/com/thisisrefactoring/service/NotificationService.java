package com.mehdirefactoring.com.thisisrefactoring.service;

import com.mehdirefactoring.com.thisisrefactoring.model.BlogPost;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    // Shotgun Surgery code smell
    public void sendEmailNotification(BlogPost blogPost) {
        System.out.println("Sending email notification for blog post: " + blogPost.getTitle());
    }

    public void sendSmsNotification(BlogPost blogPost) {
        System.out.println("Sending SMS notification for blog post: " + blogPost.getTitle());
    }

    public void sendPushNotification(BlogPost blogPost) {
        System.out.println("Sending push notification for blog post: " + blogPost.getTitle());
    }
}
