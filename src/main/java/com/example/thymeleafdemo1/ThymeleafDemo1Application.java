package com.example.thymeleafdemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThymeleafDemo1Application {

    public final static String VIEW_HOME = "home/index"; // Refers to input.html
    public final static String VIEW_INPUT = "user/input"; // Refers to input.html
    public final static String VIEW_LIST = "user/list"; // Refers to list.html

    public final static String VIEW_ATTR_PAGE_TITLE = "pageTitle";
    public final static String VIEW_ATTR_AGE_LIMIT_MIN = "ageLimitMin";
    public final static String VIEW_ATTR_AGE_LIMIT_MAX = "ageLimitMax";
    public final static String VIEW_ATTR_USER = "user";
    public final static String VIEW_ATTR_USERS = "users";

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafDemo1Application.class, args);
    }

}
