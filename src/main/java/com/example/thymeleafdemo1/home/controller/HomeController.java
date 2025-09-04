package com.example.thymeleafdemo1.home.controller;

import com.example.thymeleafdemo1.home.model.Article;
import com.example.thymeleafdemo1.view.ViewAttribute;
import com.example.thymeleafdemo1.view.ViewName;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

/**
 * This is the controller that handles the root URL and returns the start page.
 */
@Controller
public class HomeController {

    private final List<Article> articles = List.of(
            new Article("Spring and Thymeleaf", "Introduction to Spring, Thymeleaf, MVC pattern and views.", "Me", new Date(), "https://www.youtube.com/results?search_query=Spring+and+Thymeleaf+introduction", "/img/pic1.png", "Information", 100, 20, "Read More"),
            new Article("Missed the opportunity?", "Great offers, don't miss out! Check our website for more details. ", "Me", new Date(), "https://www.youtube.com/results?search_query=Spring+and+Thymeleaf+introduction", "/img/pic2.jpg", "Promotion", 100, 20, "View  More"),
            new Article("Did you see the latest?!", "New arrivals just in! Explore our latest collections.", "Me", new Date(), "https://www.youtube.com/results?search_query=Spring+and+Thymeleaf+introduction", "/img/pic3.jpg", "Product", 100, 20, "Buy Now"),
            new Article("What's up?!", "Check out these wierd new places. Soooo nice!", "Me", new Date(), "https://www.youtube.com/results?search_query=Spring+and+Thymeleaf+introduction", "/img/pic4.jpg", "Product", 100, 20, "I'm Hooked")
    );

    /**
     * This is the controller that handles the root URL and returns the start page.
     *
     * @param viewModel the model to pass data to the view
     * @return the name of the template to render
     */
    @RequestMapping("/")
    public String index(Model viewModel) {
        viewModel.addAttribute(ViewAttribute.ARTICLES.getAttributeName(), articles);
        return ViewName.HOME.getPath();
    }
}
