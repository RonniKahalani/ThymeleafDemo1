/**
 * Core JavaScript functions for navigation in the application.
 *
 * This script handles button clicks and hover effects for navigation buttons and button focus styles.
 */

// Button element placeholders. Will be initialized shortly
let btnHome;
let btnListUsers;
let btnCreateUser;
let btnSettings;
let btnAudio;
let btnVideo;

// Wait for the DOM (Document Object Model) to be fully loaded before initializing.
document.addEventListener('DOMContentLoaded', function() {
    initialize();
});

/**
 * Initialize event handlers.
 */
function initialize() {

    // Getting button elements by their id, in the HTML.
    btnHome = document.querySelector("#btnNavHome");
    btnListUsers = document.querySelector("#btnNavListUsers");
    btnCreateUser = document.querySelector("#btnNavCreateUser");
    btnSettings = document.querySelector("#btnNavSettings");
    btnAudio = document.querySelector("#btnAudio");
    btnVideo = document.querySelector("#btnVideo");

    // Setting button onclick event handlers, using => arrow functions.
    btnHome.onclick = (ev) => window.location.href = "/";
    btnListUsers.onclick = (ev) => window.location.href = "/user";
    btnCreateUser.onclick = (ev) => window.location.href = "/user/create";
    btnSettings.onclick = (ev) => underConstruction();

    // Setting button mouse event handlers.
    setMouseEventHandlers(btnHome, btnListUsers, btnCreateUser, btnSettings, btnAudio, btnVideo);
}

/**
 * Set mouse events for an element
 * @param elements
 */
function setMouseEventHandlers(...elements) {
    for (const element of elements) {
        element.onmouseover = (ev) => setFocus(element, true);
        element.onmouseout = (ev) => setFocus(element, false);
    }
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