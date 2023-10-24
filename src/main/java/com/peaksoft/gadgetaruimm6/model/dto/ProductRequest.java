package com.peaksoft.gadgetaruimm6.model.dto;

import com.peaksoft.gadgetaruimm6.model.entity.Brand;
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
    String screen;
    String guarantee;
    String processor;
    String description;
    CategoryType categoryType;
    Form form;
    Color color;
    OS os;
    MemoryRam memoryRam;
    Memory memory;
    LocalDate releaseDate;
    byte quantitySimCards;
    String enginePower;
    String diameterOfTheRear;
    String fileVideo;
    String filePDF;
    double price;
    String brandName;
    long quantityOfProducts;
    SortBy sortBy;


}
