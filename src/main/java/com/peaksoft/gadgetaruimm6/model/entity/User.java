package com.peaksoft.gadgetaruimm6.model.entity;

import com.peaksoft.gadgetaruimm6.model.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

<<<<<<< HEAD
import java.time.LocalDate;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
=======
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@FieldDefaults( level = AccessLevel.PRIVATE)
public class User {

>>>>>>> 644f8337e2bd0ba67544b3c4e7f7858563e78c59
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

    @Enumerated(EnumType.STRING)
    Role role;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
    Feedback feedbacks;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    List<Order>orders;

    @OneToOne
    @JoinColumn(name = "payment_id")
    Payment payment;

    @OneToOne
    @JoinColumn(name = "address_id")
    Address address;
}
