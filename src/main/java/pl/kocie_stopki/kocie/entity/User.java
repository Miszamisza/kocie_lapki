package pl.kocie_stopki.kocie.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import pl.kocie_stopki.kocie.registration.validator.EmailPass;
import pl.kocie_stopki.kocie.registration.validator.PassMatch;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@PassMatch
@EmailPass
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotEmpty
    private String login;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "[A-Za-z0-9._%-+]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")
    private String eMail;

    @NotNull
    @NotEmpty
    @Transient
    private String confirmEmail;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    @Transient
    private String confirmPassword;

    private boolean active;
    private boolean isAdmin;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Order> order;

    public User(int id, String userLogin, String encrytedPassword) {
        this.id = id;
        this.login = userLogin;
        this.password = encrytedPassword;
    }


    public void getLogin(String login) {
        this.login = login;
    }
}
