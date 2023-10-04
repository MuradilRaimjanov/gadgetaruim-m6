package com.peaksoft.gadgetaruimm6.model.dto.mapper;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequest {

    List<String> brands;

    List<String> colors;

    List<Integer> rams;

    List<Integer> roms;

    int priceFrom;

    int priceTo;
}
