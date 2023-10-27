package com.peaksoft.gadgetaruimm6.model.dto;

import com.peaksoft.gadgetaruimm6.model.enums.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {

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
    Gender gender;
    Wireless wireless;
    Waterproof waterproof;
    Form form;
    CategoryType categoryType;
    Color color;
    OS os;
    Memory memory;
    MemoryRam memoryRam;
    LocalDate releaseDate;
    byte quantitySimCards;
    Long articleNumber;
    String trackType;
    String enginePower;
    String engineType;
    String speedAdjustment;
    String punningTrack;
    String slopeOfTheTreadmill;
    String diameterOfTheRear;
    String programTraining;
    SortBy sortBy;


}
