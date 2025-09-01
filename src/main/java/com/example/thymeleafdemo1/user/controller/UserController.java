package com.example.thymeleafdemo1.user.controller;

import com.example.thymeleafdemo1.user.model.User;
import com.example.thymeleafdemo1.user.service.UserService;
import com.example.thymeleafdemo1.view.ViewAttribute;
import com.example.thymeleafdemo1.view.ViewName;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/*
 * This is the controller that handles the user form display and submission.
 *
 * @return the name of the template to render
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private static final String TITLE_USER_CREATE = "Create User";
    private static final String TITLE_USER_READ = "Show User";
    private static final String TITLE_USER_UPDATE = "Update User";
    private static final String TITLE_USER_LIST = "List Users";

    private final List<String> professions = List.of("Manager", "Designer", "Developer", "Other");
    private final List<String> hobbies = List.of("Cycling","Gaming", "Guitar", "Music", "Photography", "Reading", "Sports", "Traveling" );

    /**
     * These values fetched from the application.properties file, via the @Value annotations, used as attribute values in the view model.
     */
    @Value("${user.name.length.max}")
    private int userNameLengthMax;

    @Value("${user.email.length.max}")
    private int userEmailLengthMax;

    @Value("${user.age.limit.min}")
    private int userAgeLimitMin;

    @Value("${user.age.limit.max}")
    private int userAgeLimitMax;

    /**
     * Reference to the UserService for handling user-related operations
     * In the old days we would use something like this, regarding dependency injection, but now you use implicit constructor injection.
     *
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
     * @param viewModel holds the model attributes for the view
     * @return the name of the view to be rendered
     */
    @GetMapping("/create")
    public String createForm(Model viewModel) {

        // Create a new User object with default values.
        User user = new User("", "", "", "", "", new ArrayList<String>(),null, userAgeLimitMin);

        // Add the attributes to the view model so it can be accessed in the view.
        setupEditModelAttributes(viewModel);
        viewModel.addAttribute(ViewAttribute.USER.getAttributeName(), user);

        // Return the name of the view to be rendered.
        return ViewName.USER_CREATE.getPath(); // Refers to create.html
    }

    /**
     * This method displays the user form for user input.
     *
     * @param id the id of the user to be updated
     * @param viewModel holds the model attributes for the view
     * @return the name of the view to be rendered
     */
    @GetMapping("/update/{id}")
    public String updateForm(@PathVariable String id, Model viewModel) {

        validateUserId(id);
        User user = userService.findById(Long.parseLong(id));
        if (user == null) {
            throw new IllegalArgumentException("User not found for id: " + id);
        }

        // Add the attributes to the view model so it can be accessed in the view.
        setupEditModelAttributes(viewModel);
        viewModel.addAttribute(ViewAttribute.USER.getAttributeName(), user);

        // Return the name of the view to be rendered.
        return ViewName.USER_UPDATE.getPath(); // Refers to update.html
    }

    /**
     * Sets up the common model attributes for the create and update views.
     *
     * @param viewModel holds the model attributes for the view
     */
    private void setupEditModelAttributes(Model viewModel) {
        viewModel.addAttribute(ViewAttribute.USER_NAME_LENGTH_MAX.getAttributeName(), userNameLengthMax);
        viewModel.addAttribute(ViewAttribute.USER_EMAIL_LENGTH_MAX.getAttributeName(), userEmailLengthMax);
        viewModel.addAttribute(ViewAttribute.USER_AGE_LIMIT_MIN.getAttributeName(), userAgeLimitMin);
        viewModel.addAttribute(ViewAttribute.USER_AGE_LIMIT_MAX.getAttributeName(), userAgeLimitMax);
        viewModel.addAttribute(ViewAttribute.USER_PROFESSIONS.getAttributeName(), professions);
        viewModel.addAttribute(ViewAttribute.USER_HOBBIES.getAttributeName(), hobbies);
    }

    /**
     * This method displays the user form for user input.
     *
     * @param id the id of the user to be displayed
     * @param viewModel holds the model attributes for the view
     * @return the name of the view to be rendered
     */
    @GetMapping("/{id}")
    public String findById(@PathVariable String id, Model viewModel) {

        // Validate the id before using it.
        validateUserId(id);

        // Find the user via the UserService.
        User user = userService.findById(Long.parseLong(id));

        if (user == null) {
            throw new IllegalArgumentException("User not found for id: " + id);
        }

        // Add the attributes to the view model so it can be accessed in the view.
        viewModel.addAttribute(ViewAttribute.USER.getAttributeName(), user);

        // Return the name of the view to be rendered.
        return ViewName.USER_READ.getPath(); // Refers to read.html
    }

    /**
     * Validate the user id.
     *
     * @param id
     */
    private void validateUserId(String id) {
        // Validate the id before using it.
        if (id == null || id.isEmpty() || !id.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid user id: " + id);
        }
    }

    /**
     * This method handles creating a user, via form submission.
     *
     * @param user the user to be created
     * @param viewModel holds the model attributes for the view
     * @return the name of the view to be rendered
     */
    @PostMapping()
    public String createUser(@ModelAttribute("user") User user, Model viewModel) {

        // Save the user using the UserService.
        userService.save(user);

        // Return the name of the view to be rendered.
        return listAllUsers(viewModel);
    }

    /**
     * This method handles updating a user, via form submission.
     *
     * @param user the user to be created
     * @param viewModel holds the model attributes for the view
     * @return the name of the view to be rendered
     */
    @PostMapping("/{id}")
    public String updateUser(@PathVariable String id, @ModelAttribute("user") User user, Model viewModel) {

        // Save the user using the UserService.
        userService.save(user);

        // Return the name of the view to be rendered.
        return listAllUsers(viewModel);
    }

    /**
     * This method deletes a user.
     *
     * @param id the id of the user to be deleted
     * @param viewModel holds the model attributes for the view
     * @return the name of the view to be rendered
     */
    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable String id, Model viewModel) {

        userService.deleteById(Long.parseLong(id));

        // Return the name of the view to be rendered.
        return listAllUsers(viewModel);
    }

    /**
     * This method displays all users.
     *
     * @param viewModel holds the model attributes for the view
     * @return the name of the view to be rendered
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
     * @param viewModel holds the model attributes for the view
     * @return the name of the view to be rendered
     */
    private String listAllUsers(Model viewModel) {

        viewModel.addAttribute(ViewAttribute.USERS.getAttributeName(), userService.findAll());

        // Return the name of the view to be rendered.
        return ViewName.USER_LIST.getPath(); // Refers to list.html
    }
}