package com.peaksoft.gadgetaruimm6.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseToTheOrderForDelivery {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String shipping;
}