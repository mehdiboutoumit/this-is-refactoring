package com.mehdirefactoring.com.thisisrefactoring.notification;

import com.mehdirefactoring.com.thisisrefactoring.model.BlogPost;

public class PushNotification implements Notification {
    @Override
    public void send(BlogPost blogPost) {
        // Logic for push notification
        System.out.println("Sending push notification for: " + blogPost.getTitle());
    }
}

