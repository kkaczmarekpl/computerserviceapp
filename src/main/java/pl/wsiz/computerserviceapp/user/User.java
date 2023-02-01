package pl.wsiz.computerserviceapp.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.wsiz.computerserviceapp.Role;
import pl.wsiz.computerserviceapp.client.Client;

@Getter
@Setter
@ToString
@Entity
@Table(name = "`User`")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="Username")
    private String username;
    /*@Column(name="Role")
    private String role;*/
    @Column(name="Role")
    private Role role;
    @Column(name="Password")
    private String password;


    public User() {
    }

    public User(Long id, String username, Role role, String password, Client client) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.password = password;
    }

    public User(String username, Role role, String password) {
        this.username = username;
        this.role = role;
        this.password = password;
    }
}
