package com.peaksoft.gadgetaruimm6.model.entity.entity;

import com.peaksoft.gadgetaruimm6.enums.Brand;
import com.peaksoft.gadgetaruimm6.enums.Color;
import com.peaksoft.gadgetaruimm6.enums.Type;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    Brand brand;

    Color color;

    String ram;

    String rom;

    String screen;

    String dataOfIssue;

    int guarantee;

    int countSim;

    String cpu;

    int weight;

    String rating;

    Type type;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "favorite",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    List<User> userList;

    @ManyToOne (cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    Basket basket;


}
