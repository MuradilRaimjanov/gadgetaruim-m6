package com.peaksoft.gadgetaruimm6.model.entity;

import com.peaksoft.gadgetaruimm6.model.enums.OrderStatus;
import com.peaksoft.gadgetaruimm6.model.enums.PaymentType;
import com.peaksoft.gadgetaruimm6.model.enums.Review;
import com.peaksoft.gadgetaruimm6.model.enums.Shipping;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Double totalSum;
    @Column(name = "count_of_products")
    int countOfProducts;
    @Enumerated(EnumType.STRING)
    OrderStatus orderStatus;

    @Enumerated(EnumType.STRING)
    Review review;

    @Enumerated(EnumType.STRING)
    Shipping shipping;

    @Enumerated(EnumType.STRING)
    PaymentType paymentType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    Delivery deliveryPerson;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "basket_id")
    Basket basket;

    @ManyToOne
    @JoinColumn(name = "order_review_status")
    private OrderReview orderReview;

}
