package com.example.pc_builder.service;

import com.example.pc_builder.models.User;
import com.example.pc_builder.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(User user) {
        boolean usernameExists = userRepository.findByUsername(user.getUsername()).isPresent();
        if (usernameExists) {
            throw new RuntimeException("User already exists");
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        user.setPhone(userDetails.getPhone());
        user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User login(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        if (passwordEncoder.matches(password, user.getPassword())) {
            return user; // Return the authenticated user object
        } else {
            throw new RuntimeException("Invalid username and password"); // Return error message
        }
    }
}
