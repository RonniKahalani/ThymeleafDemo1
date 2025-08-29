package com.example.thymeleafdemo1.user.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        // Logic to find a user by ID (e.g., from a database in real life). This example uses a list as the repository.
        // Here are two ways to do it: The old way or with streams and functional programming.
        // The old way with for loop
        //
        // for (User u : users) {
        //   if( u.getId().equals(id) ) {
        //     return u;
        //   }
        // }
        // return null;

        // The new way since Java 8+ with functional programming, stream and filter approach
        Optional<User> user = users.stream().filter(u -> u.getId().equals(id)).findFirst();
        return user.orElse(null);
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
            user.setId(getNextId()); // Assign a new id
            users.add(user);
        } else {
            // Update existing user
            User existingUser = findById(user.getId());
            if (existingUser != null) {
                users.set(users.indexOf(existingUser), user);
            } else {
                throw new IllegalArgumentException("User with ID " + user.getId() + " not found.");
            }
        }

        System.out.println("User saved: " + user.getName());
    }

    public long getNextId() {
        return (long) users.size() + 1;
    }

    public void deleteById(Long id) {
        boolean success = users.removeIf(user -> user.getId().equals(id));
        if(!success) {
            throw new IllegalArgumentException("User with ID " + id + " not found.");
        }
    }
}
