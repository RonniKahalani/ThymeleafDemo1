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

// Using => arrow functions to set button event handlers. Its cleaner and more concise.
btnHome.onclick = (ev) => open("/");
btnListUsers.onclick = (ev)=> open("/user");
btnCreateUser.onclick = (ev)=> open("/user/create");
btnSettings.onclick = (ev) => underConstruction();

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