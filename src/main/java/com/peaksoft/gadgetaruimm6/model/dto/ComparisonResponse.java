package com.peaksoft.gadgetaruimm6.model.dto;

import com.peaksoft.gadgetaruimm6.model.entity.Brand;
import com.peaksoft.gadgetaruimm6.model.enums.Color;
import com.peaksoft.gadgetaruimm6.model.enums.MemoryRam;
import com.peaksoft.gadgetaruimm6.model.enums.OS;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ComparisonResponse {

    Long id;
    String image;
    String brand;
    Color color;
    OS os;
    MemoryRam memory;
    int weight;
    int sim;

}
