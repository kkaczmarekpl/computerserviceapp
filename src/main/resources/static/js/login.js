const editOverlay = document.getElementById("overlay");
const registerModalPanel = document.getElementById('sign-in-popup-panel');
const registerButtonClose = document.getElementById('registerButtonClose');

document.addEventListener("DOMContentLoaded", () => {
    //akcja na przycisk "create new account"
    $('#createNewAccount').on('click', function(event) {
            editOverlay.style.display = "block";
            registerModalPanel.classList.remove("modal-out");
            registerModalPanel.classList.add("modal-in");
    });
    //akcja na przycisk "Anuluj" w panelu dodawania
    $('#registerButtonClose').on('click', function(event) {
        editOverlay.style.display = "none";
        registerModalPanel.classList.remove("modal-in");
        registerModalPanel.classList.add("modal-out");
    });

    //rejestracja
    var password = document.getElementById("client-passwd")
    var confirmPassword = document.getElementById("client-passwd-repeat");

    function validatePassword(){
      if(password.value != confirmPassword.value) {
        confirmPassword.setCustomValidity("Podane hasła różnią się!");
      } else {
        confirmPassword.setCustomValidity('');
      }
    }
    password.onchange = validatePassword;
    confirmPassword.onkeyup = validatePassword;

    var usernameInput = document.getElementById("usernameLogin");
    var firstNameInput = document.getElementById("client-firstname");
    var lastNameInput = document.getElementById("client-lastname");
    var id = document.getElementById("hidden-client-id");
    console.log("ID: "+id.value);

    function createUsername() {
        firstNameInput = document.getElementById("client-firstname");
        lastNameInput = document.getElementById("client-lastname");
        usernameInput.value=(firstNameInput.value+lastNameInput.value+id.value).trim().toLowerCase();
    }
    firstNameInput.onchange = createUsername;
    lastNameInput.onchange = createUsername;


});

    function forgotPasswordClick() {
                    alert("Zresetuj swoje hasło.");
    }

    let inputPassword = document.getElementById("password");
    inputPassword.addEventListener("keypress", function(event) {
        if (event.key === "Enter") {
        event.preventDefault();
        document.getElementById("loginBtn").click();
        }
    });
