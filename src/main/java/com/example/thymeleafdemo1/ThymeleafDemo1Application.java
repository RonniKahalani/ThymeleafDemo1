package com.example.thymeleafdemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the main application class for the Thymeleaf Demo 1 application.
 * It uses Spring Boot to run the application and Thymeleaf as the template engine.
 * The application demonstrates basic Thymeleaf features such as form handling and data binding.
 */
@SpringBootApplication
public class ThymeleafDemo1Application {

    /**
     * The view names used in the application. Refers to html pages/views (without the html extension).
     */
    public final static String VIEW_HOME = "home/index";
    public final static String VIEW_INPUT = "user/input";
    public final static String VIEW_LIST = "user/list";
    public final static String VIEW_SHOW = "user/show";

    /**
     * The view model attributes used in the application, to parse data to a view model.
     */
    public final static String VIEW_ATTR_PAGE_TITLE = "pageTitle";
    public final static String VIEW_ATTR_USER_NAME_LENGTH_MAX = "userNameLengthMax";
    public final static String VIEW_ATTR_USER_EMAIL_LENGTH_MAX = "userEmailLengthMax";
    public final static String VIEW_ATTR_USER_AGE_LIMIT_MIN = "userAgeLimitMin";
    public final static String VIEW_ATTR_USER_AGE_LIMIT_MAX = "userAgeLimitMax";
    public final static String VIEW_ATTR_USER = "user";
    public final static String VIEW_ATTR_USERS = "users";

    /**
     * The main method to run the Spring Boot application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ThymeleafDemo1Application.class, args);
    }

}
