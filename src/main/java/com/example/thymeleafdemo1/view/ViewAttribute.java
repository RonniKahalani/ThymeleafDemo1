package com.example.thymeleafdemo1.view;

import lombok.Getter;

/**
 * Enum representing the view model attributes used in the application,
 * to parse data to a view model.
 */
@Getter
public enum ViewAttribute {
    ARTICLES("articles"),
    USER_NAME_LENGTH_MAX("userNameLengthMax"),
    USER_EMAIL_LENGTH_MAX("userEmailLengthMax"),
    USER_AGE_LIMIT_MIN("userAgeLimitMin"),
    USER_AGE_LIMIT_MAX("userAgeLimitMax"),
    USER("user"),
    USERS("users");

    // The name of the view attribute.
    private final String attributeName;

    /**
     * Constructor to initialize the enum constant with its associated attribute name.
     * @param attributeName
     */
    ViewAttribute(String attributeName) {
        this.attributeName = attributeName;
    }
}