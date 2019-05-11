package pl.kocie_stopki.kocie.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
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

    @OneToOne
    private Order order;

}
