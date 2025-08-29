/**
 * Core JavaScript functions for navigation in the application
 */

/**
 // Another way to select elements.
const btnHome = document.getElementById('btnNavHome');
const btnListUsers = document.getElementById('btnNavListUsers');
const btnCreateUser = document.getElementById('btnNavCreateUser');
const btnSettings = document.getElementById('btnNavSettings');
*/

/*
 Setting button elements, using document.querySelector functions.
 */
const btnHome = document.querySelector("#btnNavHome");
const btnListUsers = document.querySelector("#btnNavListUsers");
const btnCreateUser = document.querySelector("#btnNavCreateUser");
const btnSettings = document.querySelector("#btnNavSettings");

/*
 Setting button onclick event handlers, using => arrow functions.
 */
btnHome.onclick = (ev) => window.location.href = "/";
btnListUsers.onclick = (ev)=> window.location.href = "/user";
btnCreateUser.onclick = (ev)=> window.location.href = "/user/create";
btnSettings.onclick = (ev) => underConstruction();

/*
 Setting button onmouseover event handlers, using => arrow functions.
 */
btnHome.onmouseover = (ev) => setFocus(btnHome, true);
btnListUsers.onmouseover = (ev) => setFocus(btnListUsers, true);
btnCreateUser.onmouseover = (ev) => setFocus(btnCreateUser, true);
btnSettings.onmouseover = (ev) => setFocus(btnSettings, true);

/*
 Setting button onmouseout event handlers, using => arrow functions.
 */
btnHome.onmouseout = (ev) => setFocus(btnHome, false);
btnListUsers.onmouseout = (ev) => setFocus(btnListUsers, false);
btnCreateUser.onmouseout = (ev) => setFocus(btnCreateUser, false);
btnSettings.onmouseout = (ev) => setFocus(btnSettings, false);

/**
 * Set focus style on element
 * @param element
 * @param focus
 */
function setFocus(element, focus=true) {
    if(!focus) {
        element.style.removeProperty("background-color");
        element.style.removeProperty("color");
        return;
    }
    element.style.backgroundColor = "#4CAF50";
    element.style.color = "white";
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