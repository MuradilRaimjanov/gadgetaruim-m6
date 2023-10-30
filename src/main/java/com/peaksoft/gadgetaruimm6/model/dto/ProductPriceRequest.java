package com.peaksoft.gadgetaruimm6.model.dto;

import com.peaksoft.gadgetaruimm6.model.entity.Brand;
import com.peaksoft.gadgetaruimm6.model.enums.Color;
import com.peaksoft.gadgetaruimm6.model.enums.Memory;
import com.peaksoft.gadgetaruimm6.model.enums.MemoryRam;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductPriceRequest {
    Brand brand;
    Color color;
    Memory memory;
    MemoryRam memoryRam;
    byte quantitySimCards;
    LocalDate releaseDate;
    long quantityOfProducts;
    double price;

}
