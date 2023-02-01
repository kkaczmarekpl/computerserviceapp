/*if() {
                let list = document.getElementById("list-of-picked-up");
                let listDisplay =  window.getComputedStyle(list).pointer-events;
                if(listDisplay == "none")
                    document.getElementById("newAcceptanceModal").style.display = "all";
                else if(listDisplay == "all")
                    document.getElementById("newAcceptanceModal").style.display = "none";
            }*/
            function addNewAcceptance() {
                clearAcceptanceInputs();
                let btn = document.getElementById('newAcceptanceModal');
                let display = window.getComputedStyle(btn).display;
                if(display == "block")
                    document.getElementById("newAcceptanceModal").style.display = "none";
                else if(display == "none")
                    document.getElementById("newAcceptanceModal").style.display = "block";
            }

            let howManyNew = 1;

            function clearAcceptanceInputs() {
                document.getElementById('client-name-input').value = "";
                document.getElementById('important-data-yes').checked = false;
                document.getElementById('important-data-no').checked = false;
                document.getElementById('service-type').value = "";
                document.getElementById('estimated-cost').value = "";
                document.getElementById('description-of-the-problem').value = "";
                const pickedUp = Array.from(document.getElementsByClassName('new-picked-up-button'));
                pickedUp.forEach(picked => {
                    picked.remove();
                });
                howManyNew = 1;
            }


            let newElementButtonAdd,
                newElementInputType, newElementInputTypeDiv,
                newElementInputSerial, newElementInputSerialDiv,
                newElementInputName, newElementInputNameDiv,
                newElementInputProducer, newElementInputProducerDiv;
            const listOfPickedUp = document.getElementById("list-of-picked-up");

            $('#add-picked-up-button').on('click', function(event) {
                if(howManyNew>=5)
                    alert("Nie możesz dodać więcej sprzętu!")
                else {
                    howManyNew++;
                    //towrzymy div z +
                    newElementButtonAdd = document.createElement("div");
                    newElementButtonAdd.setAttribute("class", "add-picked-up-button");
                    //newElementButtonAdd.setAttribute("id", "add-picked-up-button");
                    /*const node = document.createTextNode("+");
                    newElementButtonAdd.appendChild(node);*/
                    listOfPickedUp.appendChild(newElementButtonAdd);

                    newElementInputTypeDiv = document.createElement("div");
                    newElementInputType = document.createElement("input");
                    newElementInputType.setAttribute("type", "text");
                    newElementInputType.setAttribute("placeholder", "Wpisz typ urządzenia...");
                    newElementInputType.setAttribute("name", "type");
                    newElementInputType.setAttribute("id", "hardware-type"+howManyNew);
                    newElementInputType.setAttribute("class", "new-acceptance-inputs-padding");
                    newElementInputTypeDiv.appendChild(newElementInputType);
                    listOfPickedUp.appendChild(newElementInputTypeDiv);

                    newElementInputSerialDiv = document.createElement("div");
                    newElementInputSerial = document.createElement("input");
                    newElementInputSerial.setAttribute("type", "text");
                    newElementInputSerial.setAttribute("placeholder", "Wpisz numer seryjny...");
                    newElementInputSerial.setAttribute("name", "serialNumber");
                    newElementInputSerial.setAttribute("id", "hardware-serial"+howManyNew);
                    newElementInputSerial.setAttribute("class", "new-acceptance-inputs-padding");
                    newElementInputSerialDiv.appendChild(newElementInputSerial);
                    listOfPickedUp.appendChild(newElementInputSerialDiv);

                    newElementInputNameDiv = document.createElement("div");
                    newElementInputName = document.createElement("input");
                    newElementInputName.setAttribute("type", "text");
                    newElementInputName.setAttribute("placeholder", "Wpisz nazwę urządzenia...");
                    newElementInputName.setAttribute("name", "name");
                    newElementInputName.setAttribute("id", "hardware-name"+howManyNew);
                    newElementInputName.setAttribute("class", "new-acceptance-inputs-padding");
                    newElementInputNameDiv.appendChild(newElementInputName);
                    listOfPickedUp.appendChild(newElementInputNameDiv);

                    newElementInputProducerDiv = document.createElement("div");
                    newElementInputProducer = document.createElement("input");
                    newElementInputProducer.setAttribute("type", "text");
                    newElementInputProducer.setAttribute("placeholder", "Wpisz producenta...");
                    newElementInputProducer.setAttribute("name", "producer");
                    newElementInputProducer.setAttribute("id", "hardware-producer"+howManyNew);
                    newElementInputProducer.setAttribute("class", "new-acceptance-inputs-padding");
                    newElementInputProducerDiv.appendChild(newElementInputProducer);
                    listOfPickedUp.appendChild(newElementInputProducerDiv);
                }
            });

            /*const logoutButton = document.getElementById("logout");

            logout.addEventListener('click', function() {
                window.location.href = "/index";
            });*/