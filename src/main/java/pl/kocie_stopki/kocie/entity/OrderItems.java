package pl.kocie_stopki.kocie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_order;

    @OneToOne(mappedBy = "id_user")
    private User user;


}
