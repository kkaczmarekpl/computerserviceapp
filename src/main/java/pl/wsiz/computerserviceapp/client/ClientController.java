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
    @PostMapping("/register")
    public String registerClient(Client client, Model model) {
/*        Employee newEmployee = new Employee();
        newEmployee.setFirstName(employee.getFirstName());
        newEmployee.setLastName(employee.getLastName());
        newEmployee.setPermissionType(employee.getPermissionType());
        newEmployee.setPassword(employee.getPassword());
        newEmployee.setDateOfEmployment(employee.getDateOfEmployment());*/
        clientService.addClient(client);
        model.addAttribute("registersuccess", true);
        return "redirect:/login";
    }
    @GetMapping("/index/clients/getClient/{id}")
    @ResponseBody
    public Optional<Client> getClient(@PathVariable Long id) {
        return clientService.getClient(id);
    }
    @RequestMapping(value="/index/clients/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String updateClient(Client client, Long id) {
        clientService.updateClient(client);
        return "redirect:/index/clients";
    }
    @RequestMapping(value="/index/clients/delete/{id}", method = RequestMethod.GET)
    public String deleteClient(@PathVariable(name="id") Long id) {
        clientService.deleteClient(id);
        return "redirect:/index/clients";
    }

}
