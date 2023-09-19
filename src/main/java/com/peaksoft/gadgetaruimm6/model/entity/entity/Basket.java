package com.peaksoft.gadgetaruimm6.model.entity.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "baskets")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    int countOfProduct;

    int discount;

    int sumOfProduct;

    int finishSum;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
            @JoinColumn(name = "basket_id")
    List<Product> productList;





}
