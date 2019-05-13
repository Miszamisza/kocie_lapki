package pl.kocie_stopki.kocie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

@ToString
@Data
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String login;
    @Email(message = "Email should be valid")
    private String eMail;
    @Transient
    private String confirmEmail;
    private String password;
    @Transient
    private String confirmPassword;
    private boolean active;
    private boolean isAdmin;

    @OneToOne
    private Order order;

    @ManyToMany
    private Set<Role> role;



    public User(String login, String eMail, String password) {
        this.login = login;
        this.eMail = eMail;
        this.password =password;
    }
}
