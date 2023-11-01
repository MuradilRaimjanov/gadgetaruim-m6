package com.peaksoft.gadgetaruimm6.model.dto;

import com.peaksoft.gadgetaruimm6.model.entity.Product;
import com.peaksoft.gadgetaruimm6.model.enums.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {

    Long id;
    int weight;
    String name;
    String image;
    double price;
    String screen;
    String guarantee;
    String processor;
    String description;
    String fileVideo;
    String filePDF;
    int quantityOfProducts;
    Gender gender;
    Wireless wireless;
    Waterproof waterproof;
    Form form;
    CategoryType categoryType;
    Color color;
    OS os;
    MemoryRom memoryRom;
    MemoryRam memoryRam;
    LocalDate releaseDate;
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
    List<Product> products;
}
