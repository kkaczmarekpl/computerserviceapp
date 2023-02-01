const editButtonClose = document.getElementById("editModalClose");
const editModal = document.getElementById("editClientModal");
const editOverlay = document.getElementById("overlay");
const addNewClientButton = document.getElementById("addNewButton");
const newClientModal = document.getElementById('newClientModal');
const addNewButtonClose = document.getElementById('addNewButtonClose');
const deleteClientModal = document.getElementById('deleteWarning');
const deleteButtonClose = document.getElementById('deleteModalClose');

document.addEventListener("DOMContentLoaded", () => {
    //przycisk edytuj na liście
    $('table #editButton').on('click', function(event) {
        event.preventDefault();
        var href1 = $(this).attr('href');
        href1 = this.href.replace('?id=', '');
        var href = href1.replace('http://localhost:8090', '');
        $.get(href, function(client) {
            $('#editIdTitle').text("DANE KLIENTA(ID: "+client.id+")");
            var idVal = client.id;
            $('#editClientId').val(client.id);
            $('#editClientFirstname').val(client.firstName);
            $('#editClientLastname').val(client.lastName);
            $('#editClientPhone').val(client.phoneNumber);
            $('#editClientMail').val(client.email);
            $('#editClientPassword').val(client.password);
            $('#editClientPasswordRepeat').val(client.password);
        });
        setTimeout(function(){
        },500);

        editOverlay.style.display = "block";
        editModal.classList.remove("modal-out");
        editModal.classList.add("modal-in");
    });

    //przycisk na liście "usuń"
    $('table #deleteButton').on('click', function(event) {
            event.preventDefault();
            var href = $(this).attr('href');

            setTimeout(function(){
            },500);

            editOverlay.style.display = "block";
            deleteClientModal.classList.remove("modal-out");
            deleteClientModal.classList.add("modal-in");

            $('#deleteModalClose').on('click', function(event) {
                editOverlay.style.display = "none";
                deleteClientModal.classList.remove("modal-in");
                deleteClientModal.classList.add("modal-out");
            });

            $('#deleteModalConfirm').on('click', function(event) {
                $.get(href, function(client) {
                    editOverlay.style.display = "none";
                    deleteClientModal.classList.remove("modal-in");
                    deleteClientModal.classList.add("modal-out");
                    window.location.replace("/index/clients");
                });
            });

        });

    //akcja na przycisk "dodaj klienta"
    $('#addNewButton').on('click', function(event) {
            editOverlay.style.display = "block";
            //newClientModal.style.display = "block";
            newClientModal.classList.remove("modal-out");
            newClientModal.classList.add("modal-in");
    });
    //akcja na przycisk "Anuluj" w panelu dodawania
    $('#addNewButtonClose').on('click', function(event) {
        editOverlay.style.display = "none";
        newClientModal.classList.remove("modal-in");
        newClientModal.classList.add("modal-out");
    });
    //akcja na przycisk "Anuluj" w panelu edycji
    $('#editModalClose').on('click', function(event) {
        editOverlay.style.display = "none";
        editModal.classList.remove("modal-in");
        editModal.classList.add("modal-out");
    });
});

            function editClient() {
                let btn = document.getElementById('editClientModal');
                let display = window.getComputedStyle(btn).display;
                if(display == "block")
                    document.getElementById("editClientModal").style.display = "none";
                else if(display == "none")
                    document.getElementById("editClientModal").style.display = "block";
            }

            function clearAcceptanceInputs() {
                document.getElementById('client-firstname').value = "";
                document.getElementById('client-lastname').value = "";
                document.getElementById('client-phone').value = "";
                document.getElementById('client-email').value = "";
                document.getElementById('client-passwd').value = "";
            }

            const logoutButton = document.getElementById("logout");

            logout.addEventListener('click', function() {
                window.location.href = "/index";
            });
