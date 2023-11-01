package com.peaksoft.gadgetaruimm6.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mailing")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Mailing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String description;
    String image;

    LocalDate startOfSale;
    LocalDate endOfSale;

}