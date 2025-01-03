package com.mehdirefactoring.com.thisisrefactoring.notification;

import com.mehdirefactoring.com.thisisrefactoring.model.BlogPost;

import java.util.List;

public class NotificationManager {
    private final List<Notification> notifications;

    public NotificationManager(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public void notifyAll(BlogPost blogPost) {
        for (Notification notification : notifications) {
            notification.send(blogPost);
        }
    }
}

