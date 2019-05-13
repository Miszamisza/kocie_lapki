package pl.kocie_stopki.kocie.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private String description;
    private int quantity;
    private String imageLink;

//    @JsonManagedReference
    @ManyToMany(mappedBy = "items")
    private Set<Order> orders;

}
