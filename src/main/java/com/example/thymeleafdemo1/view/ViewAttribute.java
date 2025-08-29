package com.example.thymeleafdemo1.view;

import lombok.Getter;

/**
 * Enum representing the view model attributes used in the application,
 * to parse data to a view model.
 */
@Getter
public enum ViewAttribute {
    PAGE_TITLE("pageTitle"),
    MARQUEE("marquee"),
    USER_NAME_LENGTH_MAX("userNameLengthMax"),
    USER_EMAIL_LENGTH_MAX("userEmailLengthMax"),
    USER_AGE_LIMIT_MIN("userAgeLimitMin"),
    USER_AGE_LIMIT_MAX("userAgeLimitMax"),
    USER("user"),
    USERS("users");

    // The name of the view attribute.
    private final String name;

    /**
     * Constructor to initialize the enum constant with its associated name.
     * @param name
     */
    ViewAttribute(String name) {
        this.name = name;
    }
}