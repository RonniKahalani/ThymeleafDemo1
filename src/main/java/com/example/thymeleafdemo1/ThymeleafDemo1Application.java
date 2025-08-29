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
     * The main method to run the Spring Boot application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ThymeleafDemo1Application.class, args);
    }

}
