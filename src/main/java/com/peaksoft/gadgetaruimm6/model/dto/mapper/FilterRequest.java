package com.peaksoft.gadgetaruimm6.model.dto.mapper;

import com.peaksoft.gadgetaruimm6.model.enums.Memory;
import com.peaksoft.gadgetaruimm6.model.enums.MemoryRam;
import com.peaksoft.gadgetaruimm6.model.enums.SortBy;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FilterRequest {

    List<String> brands;

    List<String> colors;

    List<String> rams;

    List<String> roms;

    int priceFrom;

    int priceTo;

    SortBy sortBy;
    
}
