package com.example.thymeleafdemo1.user.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * This class serves as a repository for managing user data.
 * This class operations would typically interact with a database to retrieve all users.
 * For simplicity, we can return an empty list or a predefined list of users.
 */
@Repository
public class UserRepository {

    private static final List<User> users = new ArrayList<>();

    /**
     * This method retrieves all users from the repository.
     *
     * @return a list of all users
     */
    public List<User> findAll() {
        // Logic to retrieve all users (e.g., from a database)
        return users;
    }

    /**
     * This method finds a user by their ID.
     *
     * @param id the ID of the user to find
     * @return the user with the specified ID, or null if not found
     */
    public User findById(Long id) {
        // Logic to find a user by ID (e.g., from a database)
        return users.stream().filter(user -> user.getId() == id ).findFirst().get(); // Placeholder implementation
    }

    /**
     * This method saves a user to the repository.
     * If the user does not have an ID, a new ID is assigned.
     *
     * @param user the user to save
     */
    public void save(User user) {

        // Logic to save the user (e.g., to a database)
        if (user.getId() == null) {
            user.setId((long) (users.size() + 1)); // Assign a new ID
        }

        users.add(user);
        System.out.println("User saved: " + user.getName());
    }
}
