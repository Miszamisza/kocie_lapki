package pl.kocie_stopki.kocie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Component
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_order;

    @OneToOne(mappedBy = "order")
    private User user;

    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;

}
