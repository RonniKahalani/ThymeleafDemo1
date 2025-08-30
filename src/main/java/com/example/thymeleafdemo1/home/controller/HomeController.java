package com.example.thymeleafdemo1.home.controller;

import com.example.thymeleafdemo1.view.ViewAttribute;
import com.example.thymeleafdemo1.view.ViewName;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * This is the controller that handles the root URL and returns the start page.
 */
@Controller
public class HomeController {

    private final List<String> marquees = List.of(
            "<span class='marquee-item-introduction'>INTRODUCTION</span> This marquee is made with CSS animation and scrolls through a text defined in the HTML file, under a tag with the CSS class 'marquee' defined.",
            "<span class='marquee-item-promotion'>PROMOTION</span> Great offers, don't miss out! Check our website for more details. Limited time only! Hurry up!",
            "<span class='marquee-item-product'>PRODUCT</span> New arrivals just in! Explore our latest collection of products and find something you love.");

    /**
     * This is the controller that handles the root URL and returns the start page.
     *
     * @param viewModel the model to pass data to the view
     * @return the name of the template to render
     */
    @RequestMapping("/")
    public String index(Model viewModel) {
        viewModel.addAttribute(ViewAttribute.MARQUEE.getAttributeName(), String.join(" ", marquees));
        return ViewName.HOME.getPath();
    }
}
