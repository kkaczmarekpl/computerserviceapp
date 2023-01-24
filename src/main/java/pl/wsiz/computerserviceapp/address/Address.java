package pl.wsiz.computerserviceapp.address;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cityName;
    private String postalCode;
    private String streetName;
    private String apartmentNumber;
    private String houseNumber;

    public Address() {}

    public Address(Long id, String cityName, String postalCode, String streetName, String apartmentNumber, String houseNumber) {
        this.id = id;
        this.cityName = cityName;
        this.postalCode = postalCode;
        this.streetName = streetName;
        this.apartmentNumber = apartmentNumber;
        this.houseNumber = houseNumber;
    }
}
