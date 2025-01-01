package com.mehdirefactoring.com.thisisrefactoring.auth;

// Username and Password Authentication
public class UsernamePasswordAuthentication implements AuthenticationMethod {
    @Override
    public boolean authenticate(String user, String password) {
        // Authentication logic for username and password
        return user.equals("admin") && password.equals("password123");
    }
}



