

var selectedCustomerId = 0;
var API_URL = "http://localhost:9090";
var username = localStorage.getItem('username');
var password = localStorage.getItem('password');
var token = "Basic " + window.btoa(username + ":" + password);

function onSaveCustomer(event) {
    event.preventDefault();

    var customerName = document.getElementById('customer-name').value;
    var customerSurname = document.getElementById('customer-surname').value;
    var customerNationality = document.getElementById('customer-nationality').value;
    var customerBirthday = document.getElementById('customer-birthday').value;

    var customerObject = {};
    customerObject.id = selectedCustomerId;
    customerObject.name = customerName;
    customerObject.surname = customerSurname;
    customerObject.nationality = customerNationality;
    customerObject.birthday = customerBirthday;

    var http = new XMLHttpRequest();

    http.onload = function () {
        selectedCustomerId = 0;
        loadAllCustomers();

    }

    http.open("POST", API_URL+"/customers", true)
    http.setRequestHeader("Content-Type", "application/json")
    http.setRequestHeader("Authorization", token);
    http.send(JSON.stringify(customerObject));


}


function loadAllCustomers() {

    var http = new XMLHttpRequest();

    http.onload = function () {
        var response = this.responseText;
        var customersArray = JSON.parse(response);
        fillCustomersTable(customersArray);
    }

    http.open("GET", API_URL+"/customers", true);
    http.setRequestHeader("Authorization", token);

    http.send();

}

function fillCustomersTable(customer) {

    var customersTbodyElement = document.getElementById('customers-tbody');

    var customersTbodyHtml = "";
    for (var i = 0; i < customer.length; i++) {
        //  customersTbodyHtml += "<tr><td>" + customer[i].id + "</td>";
        //  customersTbodyHtml += "<td>" + customer[i].name + "</td>";
        //  customersTbodyHtml += "<td>" + customer[i].surname + "</td></tr>";

        customersTbodyHtml += `<tr><td>${customer[i].id}</td>`;
        customersTbodyHtml += `<td>${customer[i].name}</td>`;
        customersTbodyHtml += `<td>${customer[i].surname}</td>`;
        customersTbodyHtml += `<td>${customer[i].nationality}</td>`;
        customersTbodyHtml +=`<td>${customer[i].birthday}</td> `;

        console.log(`<td>${customer[i].nationality}</td>`);
          customersTbodyHtml += `<td><button class = 'btn btn-danger' onclick='onDeleteCustomers(${customer[i].id})'  >Sil</button>  `;
          customersTbodyHtml += `<button class = 'btn btn-primary' onclick='onEditCustomer(${customer[i].id})'>Redakte et</button></td></tr>`;

    }
    customersTbodyElement.innerHTML = customersTbodyHtml;


}

loadAllCustomers();

function onDeleteCustomers(customerId) {
    if (confirm('Silməyə Əminsiniz?')) {
        var http = new XMLHttpRequest();

        http.onload = function () {
            loadAllCustomers();
        }

        http.open("DELETE", API_URL+"/customers/" + customerId, true);
        http.setRequestHeader("Authorization", token);

        http.send();


    }
}

function onEditCustomer(customerId) {
    selectedCustomerId = customerId;


    var http = new XMLHttpRequest();

    http.onload = function () {
        var response = this.responseText;
        var customerObject = JSON.parse(response);
        document.getElementById('customer-name').value = customerObject.name;
        document.getElementById('customer-surname').value = customerObject.surname;
        document.getElementById('customer-birthday').value = customerObject.birthday;



    }

    http.open("GET", API_URL+"/customers/" + customerId, true);
    http.setRequestHeader("Authorization", token);

    http.send();

}




