package com.example.thymeleafdemo1.view;

/**
 * Enum representing the view model attributes used in the application,
 * to parse data to a view model.
 */

public enum ViewAttribute {
    PAGE_TITLE("pageTitle"),
    MARQUEE("marquee"),
    USER_NAME_LENGTH_MAX("userNameLengthMax"),
    USER_EMAIL_LENGTH_MAX("userEmailLengthMax"),
    USER_AGE_LIMIT_MIN("userAgeLimitMin"),
    USER_AGE_LIMIT_MAX("userAgeLimitMax"),
    USER("user"),
    USERS("users");

    private final String name;

    ViewAttribute(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}