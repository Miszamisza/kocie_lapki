package pl.kocie_stopki.kocie.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String email;
    private String password;
    private boolean active;

//    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Order> order;
}
