package com.example.thymeleafdemo1.view;

import lombok.Getter;

/**
 * Enum representing the view names used in the application.
 * Refers to HTML pages/views (without the HTML extension).
 */
@Getter
public enum ViewName {
    HOME("home/index"),
    USER_CREATE("user/create"),
    USER_READ("user/read"),
    USER_UPDATE("user/update"),
    USER_LIST("user/list");

    // The path of the view.
    private final String path;

    /**
     * Constructor to initialize the enum constant with its associated path.
     * @param path
     */
    ViewName(String path) {
        this.path = path;
    }
}