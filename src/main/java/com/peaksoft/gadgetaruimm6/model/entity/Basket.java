package com.peaksoft.gadgetaruimm6.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "baskets")
@FieldDefaults( level = AccessLevel.PRIVATE)
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    int sum;
    @Column(name = "discount_percent_sum")

    int discountPercentSum;

    @Column(name = "quantity_of_products")
    int quantityOfProducts;

    @Column(name = "end_sum")
    int endSum;

    @OneToOne
    User user;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "basket")
    List<Product>products;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "basket")
    Order order;
}
