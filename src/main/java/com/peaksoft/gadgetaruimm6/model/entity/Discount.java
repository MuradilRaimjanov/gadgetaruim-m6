package com.peaksoft.gadgetaruimm6.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "discounts")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDate start;
    LocalDate finish;
    int percent;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "discount")
    Product product;
}
