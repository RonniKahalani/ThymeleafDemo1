package com.example.thymeleafdemo1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException ex, Model viewModel) {
        viewModel.addAttribute("message", "Error: " + ex.getMessage());
        return "error/400";
    }

    @ExceptionHandler(Exception.class)
    public String handleGenericException(Exception ex, Model viewModel) {
        viewModel.addAttribute("message", "Error: " + ex.getMessage());
        return "error/default";

    }
}
