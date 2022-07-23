var API_URL = "http://localhost:8585";
var usernameInput = document.getElementById('username');
var passwordInput = document.getElementById('password');

function onSignup(event){
     event.preventDefault();
     var username = usernameInput.value;
     var password = passwordInput.value;
     var http = new XMLHttpRequest();

     http.onload = function(){
         var response = this.responseText;
         var user = JSON.parse(response);
         if(user.username==""){
             alert("Bu istifadəçi adı artıq mövcuddur");
         }else{
            alert('Success');
          }
     }
     var userObject={};
     userObject.username=username;
     userObject.password=password;

     http.open("POST",API_URL + "/users", true );
     http.setRequestHeader("Content-Type","application/json");
     http.send(JSON.stringify(userObject));


 }


 function onOpenLoginPage(){
     window.location.href = 'login.html';
 }