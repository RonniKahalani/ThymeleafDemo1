package com.example.thymeleafdemo1.user.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** * Represents a user with a unique identifier, name, and age.
 * This class is used for form binding in Thymeleaf templates.
 */
@Getter
@Setter
@NoArgsConstructor
public class User {

    private Long id;
    private String name;
    private String email;
    private int age;

    /**
     * Constructs a User with the specified name and age.
     * A user id is automatically generated when the user is added via the UserRepository.
     *
     * @param name the name of the user
     * @param age  the age of the user
     */
    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
}