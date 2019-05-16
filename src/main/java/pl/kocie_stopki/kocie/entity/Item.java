package pl.kocie_stopki.kocie.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
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

    @JsonManagedReference
    @ManyToMany(mappedBy = "items")
    private Set<Order> orders;

    public Item(String name, Double price, String description, int quantity, String imageLink) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.imageLink = imageLink;
    }
}