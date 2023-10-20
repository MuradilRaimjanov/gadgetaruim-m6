package com.peaksoft.gadgetaruimm6.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "brands")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String brandName;

    String image;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "brands_products",
            inverseJoinColumns = @JoinColumn(name = "product_id"),
            joinColumns = @JoinColumn(name = "brand_id"))
    List<Product> products;

}
