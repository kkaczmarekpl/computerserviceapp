package pl.wsiz.computerserviceapp.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wsiz.computerserviceapp.employee.Employee;
import pl.wsiz.computerserviceapp.servicerequest.ServiceRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/index/clients")
    public String getAllClients(Model model) {
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("client", clients);
        return "clients";
    }

    @PostMapping("/index/clients/addNew")
    public String addClient(Client client) {
/*        Employee newEmployee = new Employee();
        newEmployee.setFirstName(employee.getFirstName());
        newEmployee.setLastName(employee.getLastName());
        newEmployee.setPermissionType(employee.getPermissionType());
        newEmployee.setPassword(employee.getPassword());
        newEmployee.setDateOfEmployment(employee.getDateOfEmployment());*/
        clientService.addClient(client);
        return "redirect:/index/clients";
    }
    @GetMapping("/clients/{id}")
    public Optional<Client> getClient(@PathVariable Long id) {
        return clientService.getClient(id);
    }
/*    @PostMapping("/clients")
    public void addClient(@RequestBody Client client) {
        clientService.addClient(client);
    }*/
    @PutMapping("/clients/{id}")
    public void updateClient(@RequestBody Client client, @PathVariable Long id) {
        clientService.updateClient(id, client);
    }
    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }

}
