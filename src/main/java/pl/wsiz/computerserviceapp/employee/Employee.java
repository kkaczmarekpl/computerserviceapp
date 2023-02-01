package pl.wsiz.computerserviceapp.employee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.wsiz.computerserviceapp.user.User;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String permissionType;
    private LocalDate dateOfEmployment;
    private String password;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FK_UserID", referencedColumnName="ID")
    private User user;

    public Employee() {}
    public Employee(Long id, String firstName, String lastName, String permissionType, LocalDate dateOfEmployment, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.permissionType = permissionType;
        this.dateOfEmployment = dateOfEmployment;
        this.password = password;
    }
}
