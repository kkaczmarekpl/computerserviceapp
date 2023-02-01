const editButtonClose = document.getElementById("editModalClose");
const editModal = document.getElementById("editEmployeeModal");
const editOverlay = document.getElementById("overlay");
const newEmployeeModal = document.getElementById('newEmployeeModal');
const addNewButtonClose = document.getElementById('addNewButtonClose');
const deleteEmployeeModal = document.getElementById('deleteWarning');
const deleteButtonClose = document.getElementById('deleteModalClose');

document.addEventListener("DOMContentLoaded", () => {
    //przycisk edytuj na liście
    $('table #editButton').on('click', function(event) {
        event.preventDefault();
        var href1 = $(this).attr('href');
        var href2=href1;
        href1 = this.href.replace('?id=', '');
        var href = href1.replace('http://localhost:8090', '');
        $.get(href2, function(employee) {
            $('#editIdTitle').text("DANE PRACOWNIKA(ID: "+employee.id+")");
            $('#editEmployeeId').val(employee.id);
            $('#editEmployeeFirstname').val(employee.firstName);
            $('#editEmployeeLastname').val(employee.lastName);
            $('#editEmployeePosition').val(employee.permissionType);
            $('#editEmployeeDate').val(employee.dateOfEmployment);
            $('#editEmployeePassword').val(employee.password);
            $('#editEmployeePasswordRepeat').val(employee.password);
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
            deleteEmployeeModal.classList.remove("modal-out");
            deleteEmployeeModal.classList.add("modal-in");

            $('#deleteModalClose').on('click', function(event) {
                editOverlay.style.display = "none";
                deleteEmployeeModal.classList.remove("modal-in");
                deleteEmployeeModal.classList.add("modal-out");
            });

            $('#deleteModalConfirm').on('click', function(event) {
                $.get(href, function(client) {
                    editOverlay.style.display = "none";
                    deleteEmployeeModal.classList.remove("modal-in");
                    deleteEmployeeModal.classList.add("modal-out");
                    window.location.replace("/index/employees");
                });
            });

        });

    //akcja na przycisk "dodaj klienta"
    $('#addNewButton').on('click', function(event) {
            editOverlay.style.display = "block";
            //newClientModal.style.display = "block";
            newEmployeeModal.classList.remove("modal-out");
            newEmployeeModal.classList.add("modal-in");
    });
    //akcja na przycisk "Anuluj" w panelu dodawania
    $('#addNewButtonClose').on('click', function(event) {
        editOverlay.style.display = "none";
        newEmployeeModal.classList.remove("modal-in");
        newEmployeeModal.classList.add("modal-out");
    });
    //akcja na przycisk "Anuluj" w panelu edycji
    $('#editModalClose').on('click', function(event) {
        editOverlay.style.display = "none";
        editModal.classList.remove("modal-in");
        editModal.classList.add("modal-out");
    });

        var password = document.getElementById("employee-passwd")
        var confirmPassword = document.getElementById("employee-passwd-repeat");

        function validatePassword(){
          if(password.value != confirmPassword.value) {
            confirmPassword.setCustomValidity("Podane hasła różnią się!");
          } else {
            confirmPassword.setCustomValidity('');
          }
        }
        password.onchange = validatePassword;
        confirmPassword.onkeyup = validatePassword;
});

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
