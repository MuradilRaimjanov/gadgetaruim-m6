package com.peaksoft.gadgetaruimm6.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MainPageResponse {

    List<FilterResponse> sale;
    List<FilterResponse> newItems;
    List<FilterResponse> recommend;
}
