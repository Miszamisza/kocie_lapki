package pl.kocie_stopki.kocie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;
@Data
@AllArgsConstructor
@Entity(name = "role")
class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private boolean isAdmin;

    @ManyToMany(mappedBy = "role")
    private Set<User> users;
}
