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
    int totalSum;
    @Column(name = "count_of_products")
    int countOfProducts;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    Delivery deliveryPerson;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "basket_id")
    Basket basket;

}
