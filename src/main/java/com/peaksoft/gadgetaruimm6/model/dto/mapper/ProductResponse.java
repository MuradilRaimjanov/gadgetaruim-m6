package com.peaksoft.gadgetaruimm6.model.dto.mapper;

import com.peaksoft.gadgetaruimm6.model.enums.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {

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
    CategoryType categoryType;
    Brand brand;
    Color color;
    OS os;
    Memory memory;
    LocalDate releaseDate;
    int quantitySimCards;
    int articleNumber;
    String trackType;
    String enginePower;
    String engineType;
    String speedAdjustment;
    String punningTrack;
    String slopeOfTheTreadmill;
    String diameterOfTheRear;
    String programTraining;

}
