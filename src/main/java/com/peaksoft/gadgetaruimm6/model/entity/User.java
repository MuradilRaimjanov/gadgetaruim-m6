package com.peaksoft.gadgetaruimm6.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@FieldDefaults( level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name="first_name")
    String firstName;

    @Column(name="last_name")
    String lastName;
    String email;
    String password;
    LocalDate createdDate;
    String phoneNumber;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "cust_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    List<Role> roles = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
    Feedback feedbacks;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    List<Order> orders;

    @OneToOne
    @JoinColumn(name = "payment_id")
    Payment payment;

    @OneToOne
    @JoinColumn(name = "address_id")
    Address address;
}
