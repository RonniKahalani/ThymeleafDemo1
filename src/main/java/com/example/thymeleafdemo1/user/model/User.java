package com.example.thymeleafdemo1.user.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/** * Represents a user with a unique identifier, name, and age.
 * This class is used for form binding in Thymeleaf templates.
 */
@Getter
@Setter
@NoArgsConstructor
public class User {

    private Long id;
    private String name;
    private String description;
    private String phone;
    private String email;
    private String profession;
    private List<String> hobbies;
    private String image;
    private int age;

    /**
     * Constructs a User with the specified name and age.
     * A user id is automatically generated when the user is added via the UserRepository.
     *
     * @param name the name of the user
     * @param description the description of the user
     * @param phone the phone of the user
     * @param email the email of the user
     * @param profession the profession of the user
     * @param hobbies the hobbies of the user
     * @param image the image of the user
     * @param age  the age of the user
     */
    public User(String name, String description, String phone, String email, String profession, List<String> hobbies, String image, int age) {
        this.name = name;
        this.description = description;
        this.phone = phone;
        this.email = email;
        this.profession = profession;
        this.hobbies = hobbies;
        this.image = image;
        this.age = age;
    }
    public User(Long id, String name, String description, String phone, String email, String profession, List<String> hobbies, String image, int age) {
        this(name, description, phone, email, profession, hobbies, image, age);
        this.id = id;
    }
}