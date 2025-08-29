package com.example.thymeleafdemo1.view;

/**
 * Enum representing the view names used in the application.
 * Refers to HTML pages/views (without the HTML extension).
 */
public enum ViewName {
    HOME("home/index"),
    USER_CREATE("user/create"),
    USER_READ("user/read"),
    USER_UPDATE("user/update"),
    USER_LIST("user/list");

    private final String path;

    ViewName(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

