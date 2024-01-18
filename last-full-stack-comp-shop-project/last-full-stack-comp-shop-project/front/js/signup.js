var API_URL = "http://localhost:8783";

function onCreateAccount(event) {
    var userNameInput = document.getElementById('username').value;
    var userPasswordInput = document.getElementById('password').value;
    var userPhoneInput = document.getElementById('phone').value;
    var NameInput = document.getElementById('name').value;
    event.preventDefault();
    var uname = userNameInput;
    var pass = userPasswordInput;
    var phoneNumber = userPhoneInput;
    var fullName = NameInput;

    // http.onload = function () {
    //     var response = this.responseText;
    //     var user = JSON.parse(response);
    //     if (user.username == "") {
    //         alert("bu istifadeci artiq movcuddur")
    //     } else {
    //         alert("Success");
    //         window.location.assign("login.html");
    //     }
    // }

    var userObject = {
        username: uname,
        password: pass,
        phone: phoneNumber,
        name: fullName
    };
    if (userNameInput != "" && userPasswordInput != "" && userPhoneInput != "" && NameInput != "")
        postResponse(JSON.stringify(userObject));
        else{
            alert('Fill the blanks!')
        }
}


function afterCreateUser(user) {
    console.log("User created: " + user);
    location.href = 'login.html';
}


async function postResponse(user) {
    const response = fetch(
        API_URL + '/users', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    }
    );
    await (await response).text().then(
        createdUser => {
            afterCreateUser(createdUser)
        }
    )
}




function onLogIn() {
    window.location.href = 'login.html';
}
function onBackToMain() {
    window.location.assign("home.html");
}