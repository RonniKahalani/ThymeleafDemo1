package com.example.thymeleafdemo1.user.controller;

import com.example.thymeleafdemo1.user.model.User;
import com.example.thymeleafdemo1.user.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.example.thymeleafdemo1.ThymeleafDemo1Application.*;

/*
 * This is the controller that handles the user form display and submission.
 *
 * @return the name of the template to render
 */

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * These values fetched from the application.properties file, via the @Value annotations, used as attribute values in the view model.
     */
    @Value( "${user.name.length.max}" )
    private int userNameLengthMax;

    @Value( "${user.email.length.max}" )
    private int userEmailLengthMax;

    @Value( "${user.age.limit.min}" )
    private int userAgeLimitMin;

    @Value( "${user.age.limit.max}" )
    private int userAgeLimitMax;

    /**
     * Reference to the UserService for handling user-related operations
     * In the old days we would use something like this, regarding dependency injection, but now you use implicit constructor injection.
     * @Autowired
     */
    private final UserService userService;

    // Constructor-based dependency injection for UserService
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
        User user = new User( "", "", userAgeLimitMin);

        // Add the attributes to the view model so it can be accessed in the view.
        viewModel.addAttribute(VIEW_ATTR_PAGE_TITLE, "Create User");
        viewModel.addAttribute(VIEW_ATTR_USER_NAME_LENGTH_MAX, userNameLengthMax);
        viewModel.addAttribute(VIEW_ATTR_USER_EMAIL_LENGTH_MAX, userEmailLengthMax);
        viewModel.addAttribute(VIEW_ATTR_USER_AGE_LIMIT_MIN, userAgeLimitMin);
        viewModel.addAttribute(VIEW_ATTR_USER_AGE_LIMIT_MAX, userAgeLimitMax);
        viewModel.addAttribute(VIEW_ATTR_USER, user);

        // Return the name of the view to be rendered.
        return VIEW_INPUT; // Refers to input.html
    }


    /**
     * This method displays the user form for user input.
     *
     * @param viewModel
     * @return
     */
    @GetMapping("/{id}")
    public String findById( @PathVariable String id, Model viewModel) {

        // Find the user via the UserService.
        User user = userService.findById(Long.parseLong(id));

        // Add the attributes to the view model so it can be accessed in the view.
        viewModel.addAttribute(VIEW_ATTR_PAGE_TITLE, "User");
        viewModel.addAttribute(VIEW_ATTR_USER, user);

        // Return the name of the view to be rendered.
        return VIEW_SHOW; // Refers to show.html
    }
    /**
     * This method handles the form submission.
     *
     * @param user
     * @param viewModel
     * @return
     */
    @PostMapping()
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
    @GetMapping()
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
        viewModel.addAttribute(VIEW_ATTR_USERS, userService.findAll());

        // Return the name of the view to be rendered.
        return VIEW_LIST; // Refers to list.html
    }
}