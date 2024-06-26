package com.peaksoft.gadgetaruimm6.model.entity;

import com.peaksoft.gadgetaruimm6.model.enums.*;
import com.peaksoft.gadgetaruimm6.model.entity.Brand;
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
    double price;
    String screen;
    String guarantee;
    String processor;
    String description;

    @Column(name = "file_pdf")
    String filePDF;
    @Column(name = "file_video")
    String fileVideo;
    @Enumerated(EnumType.STRING)
    Form form;
    @Enumerated(EnumType.STRING)
    CategoryType categoryType;
    @Enumerated(EnumType.STRING)
    Color color;
    @Enumerated(EnumType.STRING)
    OS os;

    @Enumerated(EnumType.STRING)
    @Column(name = "memory_rom")
    MemoryRom memoryRom;

    @Enumerated(EnumType.STRING)
    @Column(name = "memory_ram")
    MemoryRam memoryRam;

    @Column(name = "release_date")
    LocalDate releaseDate;
    @Column(name = "date_of_issue")
    String dateIssue;
    @Column(name = "quantity_sim_cards")
    byte quantitySimCards;
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
    @Column(name = "display_inch")
    String displayInch;
    @Column(name = "capacity_battery")
    String capacityBattery;
    @Column(name = "quantity_of_product")
    int quantityOfProducts;
    @Enumerated(EnumType.STRING)
    Gender gender;
    @Enumerated(EnumType.STRING)
    Wireless wireless;
    @Enumerated(EnumType.STRING)
    Waterproof waterproof;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "basket_id")
    Basket basket;

    @Column(name = "in_basket")
    Boolean inBasket;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "discount_id")
    Discount discount;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    List<Feedback> feedbacks;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    Brand brand;

    @ManyToOne
    @JoinColumn(name = "wishlist_id")
    Wishlist wishlist;

    @ManyToMany(mappedBy = "products", cascade = CascadeType.MERGE)
    private List<User> users;
}
