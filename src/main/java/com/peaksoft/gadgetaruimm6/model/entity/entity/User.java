package com.peaksoft.gadgetaruimm6.model.entity.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Setter
@Getter
@ToString
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    String lastName;

    String email;

    String phoneNumber;

    String password;

    String lastPassword;

    String address;

    @OneToMany
    List<Address> addressList;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "userList")
    List<Product> productList;


}
