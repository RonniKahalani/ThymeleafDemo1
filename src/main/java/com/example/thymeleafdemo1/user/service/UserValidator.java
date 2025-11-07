package com.example.thymeleafdemo1.user.service;

import com.example.thymeleafdemo1.user.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    /**
     * These values fetched from the application.properties file, via the @Value annotations, used as attribute values in the view model.
     */
    public static final int USER_NAME_LENGTH_MAX = 255;
    public static final int USER_EMAIL_LENGTH_MAX = 255;
    public static final int USER_AGE_LIMIT_MIN =  8;
    public static final int USER_AGE_LIMIT_MAX = 130;

    public static void validate(User user) throws IllegalArgumentException {

        String name = user.getName();
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("User name cannot be empty");
        }

        if (name.length() > USER_NAME_LENGTH_MAX) {
            throw new IllegalArgumentException("User name cannot be more than " + USER_NAME_LENGTH_MAX + " characters.");
        }

        String email = user.getEmail();
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("User email cannot be empty");
        }

        if (email.length() > USER_EMAIL_LENGTH_MAX) {
            throw new IllegalArgumentException("User email cannot be more than " + USER_EMAIL_LENGTH_MAX + " characters.");
        }

        int age = user.getAge();
        if (age < USER_AGE_LIMIT_MIN || age > USER_AGE_LIMIT_MAX) {
            throw new IllegalArgumentException("User age cannot be less than %d years of age and cannot be above %d years of age.".formatted(USER_AGE_LIMIT_MIN, USER_AGE_LIMIT_MAX));
        }

    }
}
