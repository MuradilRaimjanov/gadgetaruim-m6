package com.peaksoft.gadgetaruimm6.model.dto.mapper;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BasketResponse {

    int countOfProduct;
    int countDiscPrice;
    int allSum;
    int endSum;
    List<ProductFilterResponse> products;
    String massage;
}
