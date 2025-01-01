package com.mehdirefactoring.com.thisisrefactoring.service;


import com.mehdirefactoring.com.thisisrefactoring.model.User;
import com.mehdirefactoring.com.thisisrefactoring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Method to create a User with duplicated validation logic
    public void createUser(String username, String email) {
        if (username.length() > 50) {  // Duplicated logic for length validation
            throw new IllegalArgumentException("Username cannot exceed 50 characters");
        }
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        userRepository.save(user);
    }
}
