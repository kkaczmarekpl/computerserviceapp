package pl.wsiz.computerserviceapp.hardware;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.wsiz.computerserviceapp.client.Client;
import pl.wsiz.computerserviceapp.companyclient.CompanyClient;
@Getter
@Setter
@ToString
@Entity
@Table(name = "Hardware")
public class Hardware {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String serialNumber;
    private String name;
    private String producer;
    private boolean released;

    public Hardware() {}

    public Hardware(Long id, String type, String serialNumber, String name, String producer, boolean released) {
        this.id = id;
        this.type = type;
        this.serialNumber = serialNumber;
        this.name = name;
        this.producer = producer;
        this.released = released;
    }
}
