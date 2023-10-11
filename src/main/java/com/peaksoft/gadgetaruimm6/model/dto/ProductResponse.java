package com.peaksoft.gadgetaruimm6.model.dto;

import com.peaksoft.gadgetaruimm6.model.entity.Discount;
import com.peaksoft.gadgetaruimm6.model.entity.Feedback;
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
    List<BrandResponse> brands;
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
    Discount discount;
    List<Feedback> feedbacks;
    LocalDate localDate;
    Long quantityOfProduct;
}
