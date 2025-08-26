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
        // This method would typically interact with a database to retrieve a user by ID.
        // For simplicity, we can return null or a predefined user.
        return userRepository.findById(id); // Placeholder for actual user retrieval logic
    }

    public void saveUser(User user) {
        // This method would typically interact with a database to save a user.
        // For simplicity, we can just print the user's name or perform some other action.
        validateUser(user);
        userRepository.save(user); // Placeholder for actual user saving logic
    }

    private void validateUser(User user) {
        // Perform validation on the user object
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be empty");
        }
        if (user.getAge() < 18) {
            throw new IllegalArgumentException("User age cannot be less than 18 years of age.");
        }
        // Additional validation logic can be added here
    }
}
