/**
 * Core JavaScript functions for navigation in the application
 */

/**
 * Function to navigate to the home page
 */
function home() {
    location.href = "/";
}

/**
 * Function to navigate to the user list page
 */
function listUsers() {
    location.href = "/users";
}

/**
 * Function to navigate to the user form page
 */
function addUser() {
    location.href = "/form";
}

/**
 * Event listeners for navigation buttons
 */
document.getElementById("btnHome").addEventListener("click", home);
document.getElementById("btnListUsers").addEventListener("click", listUsers);
document.getElementById("btnAddUser").addEventListener("click", addUser);
