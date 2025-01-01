package com.mehdirefactoring.com.thisisrefactoring.auth;

// OAuth Authentication
public class OAuthAuthentication implements AuthenticationMethod {
    @Override
    public boolean authenticate(String user, String password) {
        // Placeholder for OAuth logic (e.g., login via Google, Twitter)
        return false; // Just for illustration
    }
}

