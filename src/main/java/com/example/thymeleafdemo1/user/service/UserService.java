package com.example.thymeleafdemo1.user.service;

import com.example.thymeleafdemo1.user.model.User;
import com.example.thymeleafdemo1.user.model.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This service class handles user-related operations.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll(); // Placeholder for actual user retrieval logic
    }

    public User findById(Long id) {
        return userRepository.findById(id);
    }

    public void save(User user) {
        validate(user);
        userRepository.save(user);
    }

    private void validate(User user) {

        // Perform validation on the user object.
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be empty");
        }
        if (user.getAge() < 18) {
            throw new IllegalArgumentException("User age cannot be less than 18 years of age.");
        }
    }
}
