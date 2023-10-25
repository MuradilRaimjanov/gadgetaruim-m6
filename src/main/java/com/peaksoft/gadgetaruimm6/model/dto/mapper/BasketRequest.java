package com.peaksoft.gadgetaruimm6.model.dto.mapper;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BasketRequest {
    Long productId;
}
