package com.peaksoft.gadgetaruimm6.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscountRequest {

    Long discountId;
    LocalDate dateOfStart;
    LocalDate dateOfEnd;
    int percent;
}
