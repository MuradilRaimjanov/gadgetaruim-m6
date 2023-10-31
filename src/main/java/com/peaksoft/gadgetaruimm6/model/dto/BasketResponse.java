package com.peaksoft.gadgetaruimm6.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BasketResponse {

    int countOfProduct;
    double countDiscPrice;
    double allSum;
    double endSum;
    List<FilterResponse> products;
    String massage;
}
