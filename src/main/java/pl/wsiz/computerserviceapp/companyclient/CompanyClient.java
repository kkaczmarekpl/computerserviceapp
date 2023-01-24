package pl.wsiz.computerserviceapp.companyclient;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.wsiz.computerserviceapp.address.Address;

@Getter
@Setter
@ToString
@Entity
@Table(name = "CompanyClient")
public class CompanyClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String companyName;
    private int NIP;
    private int REGON;
    @ManyToOne
    @JoinColumn(name="FK_AddressID", referencedColumnName="ID")
    private Address address;
    public CompanyClient() {}
    public CompanyClient(int id, String companyName, int NIP, int REGON, Address FK_AddressID) {
        this.id = id;
        this.companyName = companyName;
        this.NIP = NIP;
        this.REGON = REGON;
        this.address = FK_AddressID;
    }
    public CompanyClient(String companyName, int NIP, int REGON, Address FK_AddressID) {
        this.companyName = companyName;
        this.NIP = NIP;
        this.REGON = REGON;
        this.address = FK_AddressID;
    }
    public CompanyClient(String companyName, int NIP, Address FK_AddressID) {
        this.companyName = companyName;
        this.NIP = NIP;
        this.address = FK_AddressID;
    }

}
