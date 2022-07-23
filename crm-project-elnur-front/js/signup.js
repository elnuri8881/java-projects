var API_URL = "http://localhost:9090";
var usernameInput = document.getElementById('username');
var passwordInput = document.getElementById('password');

function onSignup(event){
    event.preventDefault();
    var username = usernameInput.value;
    var password = passwordInput.value;
    var http = XMLHttpRequest();
    http.onload = function(){
     alert('Success');
    }
    var userObject = {};
    userObject.username = username;
    userObject.password = password;
    http.open("POST",API_URL+"/users",true);
    http.setRequestHeader("Content-Type","application/json");
    http.send(JSON.stringify(userObject));

}

function onOpenLoginPage(){
    window.location.href='login.html';
}
