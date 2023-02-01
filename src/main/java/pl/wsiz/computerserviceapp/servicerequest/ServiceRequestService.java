package pl.wsiz.computerserviceapp.servicerequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import pl.wsiz.computerserviceapp.client.Client;
import pl.wsiz.computerserviceapp.client.ClientRepository;
import pl.wsiz.computerserviceapp.client.ClientService;
import pl.wsiz.computerserviceapp.employee.EmployeeService;
import pl.wsiz.computerserviceapp.hardware.Hardware;
import pl.wsiz.computerserviceapp.hardware.HardwareService;
import pl.wsiz.computerserviceapp.requesttype.RequestType;
import pl.wsiz.computerserviceapp.requesttype.RequestTypeService;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceRequestService {
    @Autowired
    private ServiceRequestRepository serviceRequestRepository;
    @Autowired
    private RequestTypeService requestTypeService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private HardwareService hardwareService;

    private int rememberLastRequestId;

    public List<RequestType>  getAllRequestType() {
        return requestTypeService.getAllRequestType();
    }
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }
    public List<ServiceRequest> getAllServiceRequest() {
        List<ServiceRequest> serviceRequests = new ArrayList<>();
        serviceRequestRepository.findAll().forEach(serviceRequests::add);
        rememberLastRequestId = getNextRequestId(serviceRequests);
        return serviceRequests;
    }

    public ServiceRequest getServiceRequestMaxId() {
        return serviceRequestRepository.findTopByid();
    }
   public List<ServiceRequest> getServiceRequestByClient(Long id) {
        List<ServiceRequest> serviceRequests = new ArrayList<>();
        serviceRequestRepository.findByClientId(id).forEach(serviceRequests::add);
        return serviceRequests;
    }
    public void addServiceRequest(ServiceRequest serviceRequest) {
        int year = Year.now().getValue();
        Long id = 1L;
        serviceRequest.setDateOfRequest(LocalDate.now());
        serviceRequest.setRequestNumber("PS "+Integer.toString(rememberLastRequestId) + "/" + Integer.toString(year));
        serviceRequest.setRequestStatus("NEW");
        //serviceRequest.setClient(clientService.getClient().get());
        serviceRequest.setEmployee(employeeService.getEmployee(id).get());
        Hardware hardware = new Hardware();
        serviceRequestRepository.save(serviceRequest);
    }
    public Optional<ServiceRequest> getServiceRequest(Long id) {
        return serviceRequestRepository.findById(id);
    }
    public void updateServiceRequest(Long id, ServiceRequest serviceRequest) {
        serviceRequestRepository.save(serviceRequest);
    }
    public void deleteServiceRequest(Long id) {
        serviceRequestRepository.deleteById(id);
    }

    public String getCurrentDate() {
        LocalDate myDateObj = LocalDate.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = myDateObj.format(myFormatObj);
        return formattedDate;
    }

    public String getFormatedDate(LocalDate date) {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = date.format(myFormatObj);
        return formattedDate;
    }

    public int getNextRequestId(List<ServiceRequest> sr) {
        int requestId;
        if(sr.size() <= 0)
            requestId = 1;
        else
            requestId = sr.get(sr.size() - 1).getId()+1;
        return requestId;
    }

}

