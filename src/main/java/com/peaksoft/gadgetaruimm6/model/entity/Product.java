package com.peaksoft.gadgetaruimm6.model.entity;

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
    int weight;
    String name;
    String image;
    int price;
    String screen;
    String guarantee;
    String processor;
    String description;
    int rom;
    int ram;

    @Enumerated(EnumType.STRING)
    CategoryType categoryType;
    @Enumerated(EnumType.STRING)
    Brand brand;
    @Enumerated(EnumType.STRING)
    Color color;
    @Enumerated(EnumType.STRING)
    OS os;
    @Enumerated(EnumType.STRING)
    Memory memory;
    @Column(name = "release_date")
    LocalDate releaseDate;
    @Column(name = "quantity_sim_cards")
    int quantitySimCards;
    @Column(name = "article_number")
    int articleNumber;
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

    @ManyToOne
    Basket basket;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "discount_id")
    Discount discount;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    List<Feedback> feedbacks;
}
