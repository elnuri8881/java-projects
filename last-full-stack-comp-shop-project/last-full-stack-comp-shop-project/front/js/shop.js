var username = localStorage.getItem('username');
var password = localStorage.getItem('password');
var API_URL = "http://localhost:8783";
var token = "Basic " + window.btoa(username + ':' + password);

function loadAllComputers() {
    var http = new XMLHttpRequest();

    http.onload = function () {
        var response = this.responseText;
        var computersArray = JSON.parse(response);
        fillComputersTable(computersArray);
        console.log(computersArray);
    }


    http.open("GET", API_URL + "/computers/all", true);
    http.setRequestHeader("Authorization", token);
    http.send();
    
}

function fillComputersTable(computers){

    var computersTbodyElement = document.getElementById('shop-tbody');

    var computersTbodyHtml="";
    for(var i=0;i<computers.length;i++){
        var computer=computers[i];
        computersTbodyHtml+="<tr><td>"+(i+1)+"</td>";
        computersTbodyHtml+="<td>"+computer.brand+"</td>";
        computersTbodyHtml+="<td>"+computer.model+"</td>";
        computersTbodyHtml+="<td>"+computer.description+"</td>";
        computersTbodyHtml+="<td>"+computer.is_new+"</td>";
        computersTbodyHtml+="<td>"+computer.price+"</td>";
        computersTbodyHtml+="<td>"+computer.memory+"</td>";
        computersTbodyHtml+="<td>"+computer.cpu+"</td>";
        computersTbodyHtml+="<td>"+computer.drive_memory+"</td>";
        computersTbodyHtml+="<td>"+`<img src=${computer.image} height="100" />` +"</td></tr>";


    }

    computersTbodyElement.innerHTML=computersTbodyHtml;

}



loadAllComputers();

function onBackToMain() {
    window.location.assign("home.html");
}


