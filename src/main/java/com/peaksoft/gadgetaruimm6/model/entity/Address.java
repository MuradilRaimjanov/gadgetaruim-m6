package com.peaksoft.gadgetaruimm6.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "addresses")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "street_name")
    String streetName;

    @Column(name = "name")
    String cityName;

    @Column(name = "country_name")
    String countryName;

    @Column(name = "postal_code")
    String postalCode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    User user;
}
