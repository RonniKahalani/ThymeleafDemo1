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

    /** The user repository for data access. */
    private final UserRepository userRepository;

    /**
     * Constructor, with injection of UserRepository.
     *
     * @param userRepository the user repository to be injected
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieves all users from the repository.
     * @return a list of all users
     */
    public List<User> findAll() {
        return userRepository.findAll(); // Placeholder for actual user retrieval logic
    }

    /**
     * Finds a user by their ID.
     * @param id the ID of the user to find
     * @return the user with the specified ID, or null if not found
     */
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Saves a user after validating the user data.
     * @param user the user to save
     * @throws IllegalArgumentException if validation fails
     */
    public void save(User user) {
        validate(user);
        userRepository.save(user);
    }

    /**
     * Deletes a user by their id.
     * @param id
     */
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    /**
     * Validates the user data before saving.
     * This validation is also done on the client side using HTML5 form validation attributes.
     * @param user the user to validate
     * @throws IllegalArgumentException if validation fails
     */
    private void validate(User user) {

        if (user.getName() == null || user.getName().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be empty");
        }
        if (user.getAge() < 18) {
            throw new IllegalArgumentException("User age cannot be less than 18 years of age.");
        }
    }
}
