var username = document.querySelector(".username");
function onShowComputers(){
window.location.assign("Computers.html");
}
function onShopping(){
window.location.assign("shop.html");
}
function onLogout(){
localStorage.removeItem("username");
localStorage.removeItem("password");
window.location.assign("home.html");
}
function onLogin(){
window.location.assign("login.html");
}
if(localStorage.getItem('username')!=undefined){
username.innerText = localStorage.getItem('username');
$('#login').addClass("d-none");
$('#login').removeClass("d-inline-block");
}else{
    $('#login').removeClass("d-none");
    $('#login').addClass("d-inline-block");
    $('#logout').addClass("d-none");
    $('#mycomps').addClass("d-none");
};