/**
 * Core JavaScript functions for navigation in the application
 */

// Button element placeholders.
let btnHome;
let btnListUsers;
let btnCreateUser;
let btnSettings;

// Wait for the DOM to be fully loaded before initializing.
document.addEventListener('DOMContentLoaded', function() {
    initialize();
});

/**
 * Initialize event handlers.
 */
function initialize() {

    // Getting button elements by their ids.
    btnHome = document.querySelector("#btnNavHome");
    btnListUsers = document.querySelector("#btnNavListUsers");
    btnCreateUser = document.querySelector("#btnNavCreateUser");
    btnSettings = document.querySelector("#btnNavSettings");


    // Setting button onclick event handlers, using => arrow functions.
    btnHome.onclick = (ev) => window.location.href = "/";
    btnListUsers.onclick = (ev) => window.location.href = "/user";
    btnCreateUser.onclick = (ev) => window.location.href = "/user/create";
    btnSettings.onclick = (ev) => underConstruction();

    // Setting button onmouseover event handlers, using => arrow functions.
    btnHome.onmouseover = (ev) => setFocus(btnHome, true);
    btnListUsers.onmouseover = (ev) => setFocus(btnListUsers, true);
    btnCreateUser.onmouseover = (ev) => setFocus(btnCreateUser, true);
    btnSettings.onmouseover = (ev) => setFocus(btnSettings, true);

    // Setting button onmouseout event handlers, using => arrow functions.
    btnHome.onmouseout = (ev) => setFocus(btnHome, false);
    btnListUsers.onmouseout = (ev) => setFocus(btnListUsers, false);
    btnCreateUser.onmouseout = (ev) => setFocus(btnCreateUser, false);
    btnSettings.onmouseout = (ev) => setFocus(btnSettings, false);
}

/**
 * Toggle media play/stop
 * @param media
 */
function toggleMedia(media) {
    media.paused ? playMedia(media) : stopMedia(media);
}

/**
 * Play media
 * @param media
 */
function playMedia(media) {
    media.play().catch(error => {
        console.error("Error playing media:", error);
    });
}

/**
 * Stop media
 * @param media
 */
function stopMedia(media) {
    media.pause();
    media.currentTime = 0; // Reset to the beginning
}

/**
 * Set focus style on element
 * @param element
 * @param focus
 */
function setFocus(element, focus = true) {
    if (!focus) {
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