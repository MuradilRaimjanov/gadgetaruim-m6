package com.peaksoft.gadgetaruimm6.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.peaksoft.gadgetaruimm6.model.enums.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long weight;
    String name;
    String image;
    double price;
    String screen;
    String guarantee;
    String processor;
    String description;
    String fileVideo;
    String filePDF;
    long quantityOfProducts;

    @Enumerated(EnumType.STRING)
    Gender gender;
    @Enumerated(EnumType.STRING)
    SortBy sortBy;
    @Enumerated(EnumType.STRING)
    Wireless wireless;
    @Enumerated(EnumType.STRING)
    Waterproof waterproof;
    @Enumerated(EnumType.STRING)
    Form form;
    @Enumerated(EnumType.STRING)
    CategoryType categoryType;
    @Enumerated(EnumType.STRING)
    Color color;
    @Enumerated(EnumType.STRING)
    OS os;
    @Enumerated(EnumType.STRING)
    Memory memory;
    @Enumerated(EnumType.STRING)
    MemoryRam memoryRam;
    @Column(name = "release_date")
    LocalDate releaseDate;
    @Column(name = "quantity_sim_cards")
    byte quantitySimCards;
    @Column(name = "article_number")
    Long articleNumber;
    @Column(name = "track_type")
    String trackType;
    @Column(name = "engine_power")
    String enginePower;
    @Column(name = "engine_type")
    String engineType;
    @Column(name = "speed_adjustment")
    String speedAdjustment;
    @Column(name = "punning_track")
    String punningTrack;
    @Column(name = "slope_of_the_treadmill")
    String slopeOfTheTreadmill;
    @Column(name = "diameter_of_the_rear")
    String diameterOfTheRear;
    @Column(name = "program_training")
    String programTraining;

    @JsonIgnore
    @ManyToOne
    Basket basket;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "discount_id")
    Discount discount;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    List<Feedback> feedbacks;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    Brand brand;

}
