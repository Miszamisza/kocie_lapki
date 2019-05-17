package pl.kocie_stopki.kocie.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.springframework.stereotype.Component;
import pl.kocie_stopki.kocie.registration.validator.EmailPass;
import pl.kocie_stopki.kocie.registration.validator.PassMatch;

import javax.persistence.*;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
@Getter
@Setter
@PassMatch
@EmailPass
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id",
        scope = User.class)

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotEmpty
    private String login;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "[A-Za-z0-9._%-+]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")
    private String email;

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
    private boolean isadmin;

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
