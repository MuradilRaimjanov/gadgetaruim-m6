package com.peaksoft.gadgetaruimm6.model.dto;

import com.peaksoft.gadgetaruimm6.model.entity.Discount;
import com.peaksoft.gadgetaruimm6.model.entity.Feedback;
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
    String name;
    double price;
    Long weight;
    Color color;
    String brandName;
    String image;
    LocalDate releaseDate;
    OS os;
    MemoryRam memoryRam;
    Memory memory;
    byte quantitySimCards;
    String processor;
    String guarantee;
    String screen;
    String description;
    CategoryType categoryType;
    String fileVideo;
    String filePDF;
    long quantityOfProduct;
    String enginePower;
    Discount discount;
    List<Feedback> feedbacks;
    LocalDate localDate;
    SortBy sortBy;
    List<Product>products;
}
