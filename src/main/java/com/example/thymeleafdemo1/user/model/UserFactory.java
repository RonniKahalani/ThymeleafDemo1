package com.example.thymeleafdemo1.user.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Factory class to generate users.
 */
public class UserFactory {
    /**
     * Generates a list of test users.
     *
     * @return a list of User objects
     */
    public static List<User> getTestUsers() {

        List<User> users = new ArrayList<>();

        users.add(
                new User(1L,
                        "Alice Johnson",
                        "Enthusiastic learner and team player",
                        "555-0123",
                        "alice.johnson@example.com",
                        "Designer",
                        Arrays.asList("hiking", "reading", "painting"),
                        "",
                        28
                ));

        users.add(
                new User(2L,
                        "Bob Smith",
                        "Passionate about technology and music",
                        "555-9876",
                        "bob.smith@example.com",
                        "Designer",
                        Arrays.asList("guitar", "cycling", "photography"),
                        "",
                        34
                ));

        users.add(
                new User(3L,
                        "Clara Lee",
                        "Dedicated to helping others and exploring new cultures",
                        "555-4567",
                        "clara.lee@example.com",
                        "Developer",
                        Arrays.asList("traveling", "cooking", "yoga"),
                        "",
                        25
                ));

        users.add(
                new User(4L,
                        "David Brown",
                        "Problem solver with a love for adventure",
                        "555-3210",
                        "david.brown@example.com",
                        "Manager",
                        Arrays.asList("rock climbing", "chess", "gardening"),
                        "",
                        41
                ));


        return users;
    }
}