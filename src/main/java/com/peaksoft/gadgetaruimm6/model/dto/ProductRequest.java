package com.peaksoft.gadgetaruimm6.model.dto;

import com.peaksoft.gadgetaruimm6.model.enums.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {

    Long quantityOfProduct;
    int weight;
    String name;
    String image;
    String price;
    String screen;
    String guarantee;
    String processor;
    String description;
    CategoryType categoryType;
    Gender gender;
    Waterproof waterproof;
    Wireless wireless;
    Form form;
    String fileVideo;
    String filePDF;
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
    Long brandId;
    String ram;
    String rom;
    SortBy sortBy;
    int priceFrom;
    int priceTo;
}
