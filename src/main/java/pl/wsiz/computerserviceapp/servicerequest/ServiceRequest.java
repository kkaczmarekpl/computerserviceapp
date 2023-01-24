package pl.wsiz.computerserviceapp.servicerequest;

import ch.qos.logback.core.net.SyslogOutputStream;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.cglib.core.Local;
import pl.wsiz.computerserviceapp.client.Client;
import pl.wsiz.computerserviceapp.employee.Employee;
import pl.wsiz.computerserviceapp.hardware.Hardware;
import pl.wsiz.computerserviceapp.requesttype.RequestType;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Year;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
@Getter
@Setter
@ToString
@Entity
@Table(name = "ServiceRequest")
public class ServiceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name="FK_Client_ID", referencedColumnName="ID")
    private Client client;
    private LocalDate dateOfRequest;
    private boolean importantData;
    private int estimatedCost;
    private String descriptionOfTheProblem;
    private String requestNumber;
    private String requestStatus;
    @ManyToOne
    @JoinColumn(name="FK_HardwareID1", referencedColumnName="ID")
    private Hardware hardware1;
    @ManyToOne
    @JoinColumn(name="FK_HardwareID2", referencedColumnName="ID")
    private Hardware hardware2;
    @ManyToOne
    @JoinColumn(name="FK_HardwareID3", referencedColumnName="ID")
    private Hardware hardware3;
    @ManyToOne
    @JoinColumn(name="FK_HardwareID4", referencedColumnName="ID")
    private Hardware hardware4;
    @ManyToOne
    @JoinColumn(name="FK_HardwareID5", referencedColumnName="ID")
    private Hardware hardware5;
    @ManyToOne
    @JoinColumn(name="FK_RequestType_ID", referencedColumnName="ID")
    private RequestType requestType;
    @ManyToOne
    @JoinColumn(name="FK_ReceivingEmployee_ID", referencedColumnName="ID")
    private Employee employee;

    public ServiceRequest(){}

/*
    public ServiceRequest(int id, Client client, LocalDate dateOfRequest, boolean importantData, String descriptionOfTheProblem, String requestNumber, String requestStatus, RequestType FK_RequestType_ID, Employee employee) {
        this.id = id;
        this.client = client;
        this.dateOfRequest = LocalDate.now();
        //this.dateOfRequest = dateOfRequest;
        this.importantData = importantData;
        this.descriptionOfTheProblem = descriptionOfTheProblem;
        int year = Year.now().getValue();
        this.requestNumber = "PS "+Integer.toString(id) + "/" + Integer.toString(year);
        //this.requestNumber = requestNumber;
        this.requestStatus = requestStatus;
        this.requestType = FK_RequestType_ID;
        this.employee = employee;
    }
    //konstruktor uzupelniajacy automatycznie id, date, numer przyjecia (czyli bez daty, bez id, bez requestnumber)
    public ServiceRequest(Client client, boolean importantData, String descriptionOfTheProblem,  RequestType FK_RequestType_ID, Employee employee) {
        this.client = client;
        this.dateOfRequest = LocalDate.now();
        this.importantData = importantData;
        this.descriptionOfTheProblem = descriptionOfTheProblem;
        int year = Year.now().getValue();
        this.requestNumber = "PS "+Integer.toString(id) + "/" + Integer.toString(year);
        this.requestStatus = "NEW";
        this.requestType = FK_RequestType_ID;
        this.employee = employee;
    }
*/

    public ServiceRequest(int id, Client client, LocalDate dateOfRequest, boolean importantData, int estimatedCost, String descriptionOfTheProblem, String requestNumber, String requestStatus, Hardware hardware1, Hardware hardware2, Hardware hardware3, Hardware hardware4, Hardware hardware5, RequestType requestType, Employee employee) {
        this.id = id;
        this.client = client;
        this.dateOfRequest = dateOfRequest;
        this.importantData = importantData;
        this.estimatedCost = estimatedCost;
        this.descriptionOfTheProblem = descriptionOfTheProblem;
        this.requestNumber = requestNumber;
        this.requestStatus = requestStatus;
        this.hardware1 = hardware1;
        this.hardware2 = hardware2;
        this.hardware3 = hardware3;
        this.hardware4 = hardware4;
        this.hardware5 = hardware5;
        this.requestType = requestType;
        this.employee = employee;
    }

    public ServiceRequest(Client client, boolean importantData, int estimatedCost, String descriptionOfTheProblem, Hardware hardware1, Hardware hardware2, Hardware hardware3, Hardware hardware4, Hardware hardware5, RequestType requestType, Employee employee) {
        this.client = client;
        this.importantData = importantData;
        this.estimatedCost = estimatedCost;
        this.descriptionOfTheProblem = descriptionOfTheProblem;
        this.hardware1 = hardware1;
        this.hardware2 = hardware2;
        this.hardware3 = hardware3;
        this.hardware4 = hardware4;
        this.hardware5 = hardware5;
        this.requestType = requestType;
        this.employee = employee;
    }
/*
    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public RequestType getRequestType() {
        return requestType;
    }*/
}
