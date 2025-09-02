package com.example.thymeleafdemo1.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler to manage exceptions across the whole application.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles IllegalArgumentException and returns a custom error view.
     * @param ex
     * @param viewModel
     * @return
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException ex, Model viewModel) {
        viewModel.addAttribute("message", "Error: " + ex.getMessage());
        return "error/400";
    }

    /**
     * Handles all other exceptions and returns a generic error view.
     * @param exception
     * @param viewModel
     * @return
     */
    @ExceptionHandler(Exception.class)
    public String handleGenericException(Exception exception, Model viewModel) {
        viewModel.addAttribute("message", "Error: " + exception.getMessage());
        return "error/default";
    }
}
