package com.example.thymeleafdemo1.user.controller;

import com.example.thymeleafdemo1.user.model.User;
import com.example.thymeleafdemo1.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import static com.example.thymeleafdemo1.ThymeleafDemo1Application.*;

/*
 * This is the controller that handles the user form display and submission.
 *
 * @return the name of the template to render
 */

@Controller
public class UserController {

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
        User user = new User( "", "", 0);

        // Add the attributes to the view model so it can be accessed in the view.
        viewModel.addAttribute(VIEW_ATTR_PAGE_TITLE, "Create User");
        viewModel.addAttribute(VIEW_ATTR_AGE_LIMIT_MIN, 18);
        viewModel.addAttribute(VIEW_ATTR_AGE_LIMIT_MAX, 130);
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

        viewModel.addAttribute(VIEW_ATTR_PAGE_TITLE, "User Listing");
        viewModel.addAttribute(VIEW_ATTR_USERS, userService.getAllUsers());

        // Return the name of the view to be rendered.
        return VIEW_LIST; // Refers to list.html
    }
}