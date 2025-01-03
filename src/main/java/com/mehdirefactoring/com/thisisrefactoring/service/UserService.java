package com.mehdirefactoring.com.thisisrefactoring.service;


import com.mehdirefactoring.com.thisisrefactoring.auth.AuthenticationMethod;
import com.mehdirefactoring.com.thisisrefactoring.auth.UsernamePasswordAuthentication;
import com.mehdirefactoring.com.thisisrefactoring.model.User;
import com.mehdirefactoring.com.thisisrefactoring.model.valueobject.UserUpdateRequest;
import com.mehdirefactoring.com.thisisrefactoring.repository.UserRepository;
import com.mehdirefactoring.com.thisisrefactoring.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    private AuthenticationMethod authenticationMethod = new UsernamePasswordAuthentication();


    public boolean loginUser(String username, String password) {
        return authenticationMethod.authenticate(username, password);
    }

    // Introduce Utility Method to avoid duplicated validation logic
    public void createUser(String username, String email) {

        ValidationUtil.validateStringLength(username, 50,
                "Username cannot exceed 50 characters");

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        userRepository.save(user);
    }

    //  Introduce Parameter Object Refactoring technique
    public void updateUser(Long userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Update the user details
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        userRepository.save(user);
    }
}
