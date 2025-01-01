package com.mehdirefactoring.com.thisisrefactoring.auth;

// General Authentication interface
public interface AuthenticationMethod {
    boolean authenticate(String user, String password);
}

