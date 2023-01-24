package pl.wsiz.computerserviceapp.client;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.wsiz.computerserviceapp.companyclient.CompanyClient;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Client")
public class Client {

    public Client() {}
    public Client(Long id, String firstName, String lastName, String phoneNumber,
                  String email, String clientType, boolean allowNotifications, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.clientType = clientType;
        this.allowNotifications = allowNotifications;
        this.password = password;
    }

    //konstruktor ze wszystkimi parametrami
    public Client(Long id, String firstName, String lastName, String phoneNumber,
                  String email, String clientType, boolean allowNotifications, String password, CompanyClient companyClient) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.clientType = clientType;
        this.allowNotifications = allowNotifications;
        this.password = password;
        this.companyClient = companyClient;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String clientType;
    @Column(name="allowNotifications")
    private boolean allowNotifications;
    private String password;
    @ManyToOne
    @JoinColumn(name="FK_CompanyID", referencedColumnName="ID")
    private CompanyClient companyClient; //Foreign Key
}
