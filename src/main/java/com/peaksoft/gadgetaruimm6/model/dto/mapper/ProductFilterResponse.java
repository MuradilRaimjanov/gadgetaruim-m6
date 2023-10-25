package com.peaksoft.gadgetaruimm6.model.dto.mapper;

import com.peaksoft.gadgetaruimm6.model.enums.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.File;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductFilterResponse {

    Long id;
    String name;
    int price;
    String image;
    String description;
    String dateIssue;
    String screen;
    String guarantee;
    String processor;
    String weight;
    Brand brand;
    Color color;
    OS os;
    File pdf;
    Memory memoryRom;
    MemoryRam memoryRam;
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
    Boolean inBasket;
}
