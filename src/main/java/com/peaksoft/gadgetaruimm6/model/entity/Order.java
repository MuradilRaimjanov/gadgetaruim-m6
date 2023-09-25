package com.peaksoft.gadgetaruimm6.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "count_of_products")
    int countOfProducts;

    int totalSum;

    @ManyToOne
    @JoinColumn(name = "uses_id")
    User user;

    @ManyToOne
    Delivery deliveryPerson;

    @OneToOne(cascade = CascadeType.ALL)
    Basket basket;

}
