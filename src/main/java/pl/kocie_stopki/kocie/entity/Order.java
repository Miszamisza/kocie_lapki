package pl.kocie_stopki.kocie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_order;

    @OneToOne(mappedBy = "order")
    private User user;

    @OneToMany
    @JoinColumn(name = "id_item")
    private List<Item> item;

}
