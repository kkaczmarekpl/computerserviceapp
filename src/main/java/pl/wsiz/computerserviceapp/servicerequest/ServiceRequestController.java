package pl.wsiz.computerserviceapp.servicerequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wsiz.computerserviceapp.client.Client;
import pl.wsiz.computerserviceapp.client.ClientService;
import pl.wsiz.computerserviceapp.employee.Employee;
import pl.wsiz.computerserviceapp.requesttype.RequestType;
import pl.wsiz.computerserviceapp.requesttype.RequestTypeService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller
public class ServiceRequestController {

    @Autowired
    private ServiceRequestService serviceRequestService;

    /*@GetMapping("/service-request")
    public List<ServiceRequest> getAllServiceRequest() {
        return serviceRequestService.getAllServiceRequest();
    }*/
    @GetMapping("/index/service-request")
    public String getAllServiceRequest(Model model) {
        List<ServiceRequest> serviceRequests = serviceRequestService.getAllServiceRequest();
        List<RequestType> requestTypes = serviceRequestService.getAllRequestType();
        List<Client> listClients = serviceRequestService.getAllClients();
        model.addAttribute("servicerequest", serviceRequests);
        model.addAttribute("servicerequestid", serviceRequestService.getNextRequestId(serviceRequests));
        model.addAttribute("currentdate", serviceRequestService.getCurrentDate());
        model.addAttribute("servicetype", requestTypes);
        model.addAttribute("listClients", listClients);
        return "service-request";
    }
    @PostMapping("/index/service-request/addNew")
    public String addServiceRequest(@ModelAttribute("servicerequest") ServiceRequest serviceRequest, Model model) {
        model.addAttribute("listClients");
        //próba dodania clienta
        //model.getAttribute("servicerequest");
/*        String clientFirstName = model.addAttribute("clientname", serviceRequestService.).toString();
        String[] splitToFirstNameLastName = clientFirstName.trim().split("\\s+");
        Client client = new Client();
        client.setFirstName(splitToFirstNameLastName[0]);
        client.setLastName(splitToFirstNameLastName[1]);
        serviceRequest.setClient(client);*/
        //
        serviceRequestService.addServiceRequest(serviceRequest);
        return "redirect:/index/service-request";
    }
    @GetMapping("/service-request/{id}")
    public Optional<ServiceRequest> getServiceRequest(@PathVariable Long id) {
        return serviceRequestService.getServiceRequest(id);
    }

/*    @PostMapping("/service-request")
    public void addServiceRequest(@RequestBody ServiceRequest serviceRequest) {
        serviceRequestService.addServiceRequest(serviceRequest);
    }*/
    @PutMapping("/service-request/{id}")
    public void updateServiceRequest(@RequestBody ServiceRequest serviceRequest, @PathVariable Long id) {
        serviceRequestService.updateServiceRequest(id, serviceRequest);
    }
    @DeleteMapping("/service-request/{id}")
    public void deleteServiceRequest(@PathVariable Long id) {
        serviceRequestService.deleteServiceRequest(id);
    }
    @GetMapping("/service-request/client/{id}")
    public List<ServiceRequest> getServiceRequestByClient(@PathVariable Long id) {
        return serviceRequestService.getServiceRequestByClient(id);
    }
}
