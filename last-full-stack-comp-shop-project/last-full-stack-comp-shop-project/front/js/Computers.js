var username = localStorage.getItem('username');
var password = localStorage.getItem('password');
var API_URL = "http://localhost:8783";
var token = "Basic " + window.btoa(username + ':' + password);
var selectedComputerId = 0;
var computerPhotoInput = null;
var computerBrandInput = document.getElementById("brand");
var computerModelInput = document.getElementById("model");
var computerPriceInput = document.getElementById("price");
var computerDescriptionInput = document.getElementById("description");
var computerIsNewInput = document.getElementById("new");
var computerMemoryInput = document.getElementById("memory");
var computerCpuInput = document.getElementById("cpu");
var computerDriveInput = document.getElementById("drive_memory");

var gridOptionsGlobal;

var isEdit = false;


function onBackToMain() {
    window.location.assign("home.html");
}
async function onSaveComputer(event) {
    event.preventDefault();

    computerBrandInput = document.getElementById("brand").value;
    computerModelInput = document.getElementById("model").value;
    computerPriceInput = document.getElementById("price").value;
    computerDescriptionInput = document.getElementById("description").value;
    computerIsNewInput = document.getElementById("new").value;
    computerMemoryInput = document.getElementById("memory").value;
    computerCpuInput = document.getElementById("cpu").value;
    computerDriveInput = document.getElementById("drive_memory").value;
    computerPhotoInput = document.getElementById('photo');
    computerIsNewInput = computerIsNewInput == 1 ? "true" : "false";

    if (isEdit) {
        var computer = {
            brand: computerBrandInput,
            model: computerModelInput,
            price: computerPriceInput,
            description: computerDescriptionInput,
            is_new: computerIsNewInput,
            image: "",
            memory: computerMemoryInput,
            cpu: computerCpuInput,
            drive_memory: computerDriveInput,
            username: localStorage.getItem('username'),
            id: localStorage.getItem('compId')
        }
    }
    else {
        var computer = {
            brand: computerBrandInput,
            model: computerModelInput,
            price: computerPriceInput,
            description: computerDescriptionInput,
            is_new: computerIsNewInput,
            image: "",
            memory: computerMemoryInput,
            cpu: computerCpuInput,
            drive_memory: computerDriveInput,
            username: localStorage.getItem('username')
        }
    }
    isEdit = false
    getBase64(computerPhotoInput.files[0], computer);

}

function computerToObject(base64, computer) {
    computer.image = base64;
    console.log(computer.brand);
    postResponse(computer);
}

function getBase64(file, computer) {
    var reader = new FileReader();
    reader.readAsDataURL(file);
    reader.onload = function () {
        computerToObject(reader.result, computer);
    };
    reader.onerror = function (error) {
        console.log('Error: ', error);
    };
}



async function postResponse(computer) {
    const response = fetch(
        API_URL + '/computers', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(computer)
    }
    );
    await (await response).text().then(
        computerResult => {
            afterRequest(computerResult)
        }
    )
}

function afterRequest(computerResult) {
    // alert("New computer was added..");
    location.reload();
}



function loadAllComputers() {
    var http = new XMLHttpRequest();



    http.onload = function () {
        var response = this.responseText;
        var computersArray = JSON.parse(response);
        fillComputersTable(computersArray.filter(a => a.username === username));
    }
    // [1, 2, 3] {username}

    http.open("GET", API_URL + "/computers/all", true);
    http.setRequestHeader("Authorization", token);
    http.send();

}

function fillComputersTable(computers) {


    gridOptionsGlobal.api.setRowData(computers);

}


function onDeleteComputer() {
    var selectedComputers = gridOptionsGlobal.api.getSelectedRows();
    if (selectedComputers.length > 0) {
        if (confirm('Silməyə əminsinizmi?')) {
            var computerId = selectedComputers[0].id;
            var http = new XMLHttpRequest();
            http.onload = function () {
                loadAllComputers();
            }




            http.open("DELETE", API_URL + "/computers/" + computerId, true);
            http.setRequestHeader("Authorization", token);
            http.send();
        }
    } else {
        alert("Choose Minimum 1 Computer!");
    }
}
function onEditComputer() {
    isEdit = true;
    var selectedComputers = gridOptionsGlobal.api.getSelectedRows();

    if (selectedComputers.length == 1) {
        var computerId = selectedComputers[0].id;
        localStorage.setItem('compId', computerId)

        computerBrandInput.value = selectedComputers[0].brand;
        computerModelInput.value = selectedComputers[0].model;
        computerPriceInput.value = selectedComputers[0].price;
        computerDescriptionInput.value = selectedComputers[0].description;
        computerIsNewInput.value = selectedComputers[0].is_new;
        computerMemoryInput.value = selectedComputers[0].memory;
        computerCpuInput.value = selectedComputers[0].cpu;
        computerDriveInput.value = selectedComputers[0].drive_memory;
        computerPhotoInput.value = "";
        // }
        // http.open("GET", API_URL + "/computers/" + computerId, true);
        // http.setRequestHeader("Authorization", token);
        // http.send();

    } else {
        alert("You can choose only 1 computer!")
    }
    http.setRequestHeader("Authorization", token);
}






function prepareAgGridTable() {
    var autoIncrementColDef = {
        headerName: 'No',
        valueGetter: 'node.rowIndex + 1',
        width: 100
    };
    const columnDefs = [
        autoIncrementColDef,
        { field: "id", headerName: "ID" },
        { field: "brand", headerName: "Brand" },
        { field: "model", headerName: "Model" },
        { field: "cpu", headerName: "Cpu" },
        { field: "price", headerName: "Price" },
        { field: "memory", headerName: "Memory" },
        {
            field: "image",
            headerName: "Photo",
            cellRenderer: function (params) {
                const img = document.createElement('img');
                img.src = params.value;
                img.height = 100;
                return img;
            }
        }
    ];

    const gridOptions = {

        columnDefs: columnDefs,
        rowData: [],
        defaultColDef: { sortable: true },
        animateRos: true,
        floatingFilter: true,
        pagination: true,
        rowSelection: 'multiple'
    };
    gridOptionsGlobal = gridOptions;

    document.addEventListener('DOMContentLoaded', () => {
        const gridDiv = document.querySelector('#myStudents');
        new agGrid.Grid(gridDiv, gridOptions);
    });
}
prepareAgGridTable();
loadAllComputers();


function onShowImage() {
    var selectedComputers = gridOptionsGlobal.api.getSelectedRows();
    if (selectedComputers.length == 1) {
        var computerId = selectedComputers[0].id;
        document.getElementById('image-btn').src = selectedComputers[0].image;
    }
    else {
        alert('Choose min 1 computer!');
    }


    al

}