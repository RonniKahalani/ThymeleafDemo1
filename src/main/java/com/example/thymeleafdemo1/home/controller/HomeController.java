package com.example.thymeleafdemo1.home.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;
import java.util.List;

import static com.example.thymeleafdemo1.ThymeleafDemo1Application.*;

/**
 * This is the controller that handles the root URL and returns the start page.
 */
@Controller
public class HomeController {

    @Value("${spring.application.name}")
    private String TITLE_APP_NAME;

    private final List<String> marquees = List.of(
            "This marquee is made with CSS animation and scrolls through a text defined in the HTML file, under a tag with the CSS class \\\"marquee\\\" defined.",
            "Great offers, don't miss out!",
            "New arrivals just in!");

    /**
     * This is the controller that handles the root URL and returns the start page.
     *
     * @return the name of the template to render
     */
    @RequestMapping("/")
    public String index(Model viewModel) throws FileNotFoundException {

        viewModel.addAttribute(VIEW_ATTR_MARQUEE, marquees.get(0));
        viewModel.addAttribute(VIEW_ATTR_PAGE_TITLE, TITLE_APP_NAME);
        return VIEW_HOME;
    }

}
