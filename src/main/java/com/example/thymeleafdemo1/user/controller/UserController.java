package com.example.thymeleafdemo1.user.controller;

import com.example.thymeleafdemo1.user.model.User;
import com.example.thymeleafdemo1.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/*
 * This is the controller that handles the form display and submission.
 * The Thymeleaf template engine will look for a html files in the templates directory.
 *
 * @return the name of the template to render
 */

@Controller
public class UserController {

    private final String VIEW_INPUT = "user/input"; // Refers to input.html
    private final String VIEW_LIST = "user/list"; // Refers to list.html

    private final String VIEW_ATTR_USER = "user";
    private final String VIEW_ATTR_USERS = "users";

    // Reference to the UserService for handling user-related operations
    private final UserService userService;

    // Constructor injection for UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * This method displays the user form for user input.
     *
     * @param viewModel
     * @return
     */
    @GetMapping("/form")
    public String showInputForm(Model viewModel) {

        // Create a new User object with default values.
        User user = new User( "", 0);

        // Add the user object to the view model so it can be accessed in the view.
        viewModel.addAttribute("ageLimitMin", 18);
        viewModel.addAttribute("ageLimitMax", 130);

        viewModel.addAttribute(VIEW_ATTR_USER, user);
        viewModel.addAttribute(VIEW_ATTR_USER, user);

        // Return the name of the view to be rendered.
        return VIEW_INPUT; // Refers to input.html
    }

    /**
     * This method handles the form submission.
     *
     * @param user
     * @param viewModel
     * @return
     */
    @PostMapping("/submit")
    public String saveUser(@ModelAttribute(VIEW_ATTR_USER) User user, Model viewModel) {

        // Save the user using the UserService.
        userService.saveUser(user);

        // Return the name of the view to be rendered.
        return listAllUsers(viewModel);
    }

    /**
     * This method displays all users.
     *
     * @param viewModel
     * @return
     */
    @GetMapping("/users")
    public String listUsers(Model viewModel) {

        // Return all the users to the result page.
        return listAllUsers(viewModel);
    }

    /**
     * This method fetches all users and adds them to the view model.
     * It is used to display the result page with all users.
     *
     * @param viewModel
     * @return the name of the view to be rendered
     */
    private String listAllUsers(Model viewModel) {

        // Fetch all users to display on the result page
        viewModel.addAttribute(VIEW_ATTR_USERS, userService.getAllUsers());

        // Return the name of the view to be rendered.
        return VIEW_LIST; // Refers to list.html
    }
}