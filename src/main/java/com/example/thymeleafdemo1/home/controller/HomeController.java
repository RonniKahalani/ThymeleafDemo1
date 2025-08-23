package com.example.thymeleafdemo1.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    /**
     * This is the controller that handles the root URL and returns the start page.
     * The Thymeleaf template engine will look for a file named "input.html" in the templates directory.
     *
     * @return the name of the template to render
     */
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Welcome to the Thymeleaf Demo!");
        return "home/index";
    }

}
