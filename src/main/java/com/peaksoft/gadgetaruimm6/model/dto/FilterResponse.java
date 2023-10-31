package com.peaksoft.gadgetaruimm6.model.dto;

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
public class FilterResponse {

    Long id;
    int weight;
    String name;
    String image;
    double price;
    String screen;
    String guarantee;
    String processor;
    String description;
    String filPDF;
    String fileVideo;
    CategoryType categoryType;
    Color color;
    OS os;
    MemoryRom memoryRom;
    MemoryRam memoryRam;
    LocalDate releaseDate;
    String dateIssue;
    byte quantitySimCards;
    int articleNumber;
    String trackType;
    String enginePower;
    String engineType;
    String speedAdjustment;
    String punningTrack;
    String slopeOfTheTreadmill;
    String diameterOfTheRear;
    String programTraining;
    String displayInch;
    String capacityBattery;
    int quantityOfProduct;
}
