package com.mehdirefactoring.com.thisisrefactoring.notification;

import com.mehdirefactoring.com.thisisrefactoring.model.BlogPost;

public interface Notification {
    void send(BlogPost blogPost);
}

