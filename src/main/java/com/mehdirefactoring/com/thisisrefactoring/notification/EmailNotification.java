package com.mehdirefactoring.com.thisisrefactoring.notification;

import com.mehdirefactoring.com.thisisrefactoring.model.BlogPost;

public class EmailNotification implements Notification {
    @Override
    public void send(BlogPost blogPost) {
        // Logic for email notification
        System.out.println("Sending email notification for: " + blogPost.getTitle());
    }
}