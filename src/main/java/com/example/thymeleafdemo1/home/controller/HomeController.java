package com.example.thymeleafdemo1.home.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.example.thymeleafdemo1.ThymeleafDemo1Application.VIEW_ATTR_PAGE_TITLE;
import static com.example.thymeleafdemo1.ThymeleafDemo1Application.VIEW_HOME;

/**
 * This is the controller that handles the root URL and returns the start page.
 */
@Controller
public class HomeController {

    @Value("${spring.application.name}")
    private String APP_NAME;
    /**
     * This is the controller that handles the root URL and returns the start page.
     *
     * @return the name of the template to render
     */
    @RequestMapping("/")
    public String index(Model viewModel) {
        viewModel.addAttribute(VIEW_ATTR_PAGE_TITLE, APP_NAME);
        return VIEW_HOME;
    }
}
