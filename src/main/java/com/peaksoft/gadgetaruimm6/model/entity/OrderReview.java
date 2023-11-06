package com.peaksoft.gadgetaruimm6.model.entity;

import com.peaksoft.gadgetaruimm6.model.enums.Review;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "order_review")
public class OrderReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Review review;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "orderReview")
    private List<Order> orders;
}
