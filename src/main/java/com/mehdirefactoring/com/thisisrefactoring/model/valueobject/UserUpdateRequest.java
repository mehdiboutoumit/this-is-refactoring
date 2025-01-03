package com.mehdirefactoring.com.thisisrefactoring.model.valueobject;
//  Introduce Parameter Object Refactoring technique
public class UserUpdateRequest {
    private String username;
    private String email;

    public UserUpdateRequest(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}

