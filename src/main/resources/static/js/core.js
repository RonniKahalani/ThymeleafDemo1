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
let toastView;
let spinner;
let modalExample;
let modalExampleTitle;
let modalExampleBody;
let btnModalExampleOk;

// Wait for the DOM (Document Object Model) to be fully loaded before initializing.
document.addEventListener('DOMContentLoaded', function () {
    initialize();
});

/**
 * Initialize event handlers.
 */
function initialize() {

    // Getting button elements by their id, in the HTML.
    btnHome = document.querySelector("#btn-nav-home");
    btnListUsers = document.querySelector("#btn-nav-list-users");
    btnCreateUser = document.querySelector("#btn-nav-create-user");
    btnSettings = document.querySelector("#btn-nav-settings");
    btnAudio = document.querySelector("#btn-audio");
    toastView = document.querySelector("#toast-view");
    spinner = document.querySelector("#spinner");
    modalExample = document.querySelector("#modal-example");
    modalExampleTitle = document.querySelector("#modal-example-label");
    modalExampleBody = document.querySelector("#modal-example-body");
    btnModalExampleOk = document.querySelector("#btn-modal-example-ok");

    // Setting button onclick event handlers, using => arrow functions.
    btnHome.onclick = (ev) => window.location.href = "/";
    btnListUsers.onclick = (ev) => window.location.href = "/user";
    btnCreateUser.onclick = (ev) => window.location.href = "/user/create";
    btnSettings.onclick = (ev) => showModalDialog("Settings", "Settings are under construction.");
    btnModalExampleOk.onclick = (ev) => closeModalDialog();

    // Setting button mouse event handlers.
    setMouseEventHandlers(btnHome, btnListUsers, btnCreateUser, btnSettings, btnAudio);

    toggleSpinner();
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

/**
 * Toggle spinner
 */
function toggleSpinner() {
    spinner.style.display = isVisible(spinner) ? 'none' : 'block';
}

/**
 * Returns true if spinner is visible
 *
 * @param element
 * @returns {boolean}
 */
function isVisible(element) {
    const computedStyle = window.getComputedStyle(element);
    return !(
        computedStyle.display === 'none' ||
        computedStyle.visibility === 'hidden' ||
        computedStyle.opacity === '0'
    );
}

/**
 * Show welcome toast
 */
function showWelcomeToast() {
    showToast(`Hello and welcome to this site.<br>Here is a link for you to click on<br><a href="http://dr.dk">Link</a>`, "house");
}

/**
 * Show toast message
 * @param message
 * @param icon
 */
function showToast(message, icon) {
    const toastBody = toastView.querySelector('.toast-body');
    toastBody.innerHTML = message;

    if (icon) {
        const toastIcon = toastView.querySelector('#toast-icon');
        toastIcon.className = "rounded me-2 toast-icon bi bi-" + icon;
    }

    const toast = new bootstrap.Toast(toastView);
    toast.show();
}

/**
 * Show modal dialog
 * @param title
 * @param body
 */
function showModalDialog(title, body) {

    modalExampleTitle.innerHTML = title;
    modalExampleBody.innerHTML = body;

    const myModal = new bootstrap.Modal(modalExample, {
        keyboard: false
    });
    myModal.show();
}

/**
 * Close modal dialog
 */
function closeModalDialog() {
    const modalInstance = bootstrap.Modal.getInstance(modalExample);
    if (modalInstance) {
        modalInstance.hide();
        setTimeout(() => {
            console.log("User clicked Ok button in modal dialog.");
        }, 100);
    }
}