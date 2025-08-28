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

btnHome.onclick = ()=> window.location.href = "/";
btnListUsers.onclick = ()=> window.location.href = "/user";
btnCreateUser.onclick = ()=> window.location.href = "/user/create";
btnSettings.onclick = ()=> alert("Settings page is under construction.");