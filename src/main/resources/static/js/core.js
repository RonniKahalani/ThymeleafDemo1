/**
 * Core JavaScript functions for navigation in the application
 */

// Another way to select elements.
/**
const btnHome = document.getElementById('btnNavHome');
const btnListUsers = document.getElementById('btnNavListUsers');
const btnCreateUser = document.getElementById('btnNavCreateUser');
const btnSettings = document.getElementById('btnNavSettings');
*/

const btnHome = document.querySelector("#btnNavHome");
const btnListUsers = document.querySelector("#btnNavListUsers");
const btnCreateUser = document.querySelector("#btnNavCreateUser");
const btnSettings = document.querySelector("#btnNavSettings");

/*
 * Here are some examples of onclick event handling done in different ways.

// With an explicit inline anonymous function definition.
btnHome.onclick = function (ev) {
    openUrl("/");
};

// With an arrow function definition and the inline action. Because there is only onli line of code, you could remove the brackets.
btnListUsers.onclick = (ev)=> {
    window.location.href = "/user";
}

// With an arrow function definition calling another function.
btnCreateUser.onclick = (ev) => openUrl("/user/create");

// With a direct function reference.
btnSettings.onclick = underConstruction;

function openUrl(url) {
    window.location.href = url;
}
 */

// This is how I would do it using => arrow functions. Its cleaner and more concise.
btnHome.onclick = (ev) => openUrl("/");
btnListUsers.onclick = (ev)=> open("/user");
btnCreateUser.onclick = (ev)=> openUrl("/user/create");
btnSettings.onclick = (ev) => underConstruction();

/**
 * Open a URL in the current window
 * @param url
 */
function openUrl(url) {
    window.location.href = url;
}

/**
 * Alert for features under construction
 */
function underConstruction() {
    alert("This feature is under construction.");
}
/**
 * Confirm user deletion
 * @param userId
 * @returns {boolean}
 */
function confirmDelete(userId) {
    return confirm(`You are about to delete user with ID:${userId}.\nAre you sure you want to continue?`);
}