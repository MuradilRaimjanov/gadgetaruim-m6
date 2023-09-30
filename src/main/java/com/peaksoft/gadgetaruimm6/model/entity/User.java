package com.peaksoft.gadgetaruimm6.model.entity;

import com.peaksoft.gadgetaruimm6.model.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@FieldDefaults( level = AccessLevel.PRIVATE)
public class User implements UserDetails {

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

    @Enumerated(EnumType.STRING)
    Role role;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
