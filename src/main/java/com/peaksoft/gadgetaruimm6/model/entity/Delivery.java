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
@Table(name = "delivery")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @Column(name = "last_name")
    String lastName;

    @Column(name = "phone_number")
    String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deliveryPerson")
    List<Order> orders;
}
