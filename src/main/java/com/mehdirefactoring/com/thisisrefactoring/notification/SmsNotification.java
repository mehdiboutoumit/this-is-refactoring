package com.mehdirefactoring.com.thisisrefactoring.notification;

import com.mehdirefactoring.com.thisisrefactoring.model.BlogPost;

public class SmsNotification implements Notification {
    @Override
    public void send(BlogPost blogPost) {
        // Logic for SMS notification
        System.out.println("Sending SMS notification for: " + blogPost.getTitle());
    }
}
