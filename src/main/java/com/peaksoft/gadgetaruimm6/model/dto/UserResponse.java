package com.peaksoft.gadgetaruimm6.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {

    Long id;
    String name;
    String lastName;
    String email;
    String password;
    LocalDate created;
    String roleName;
}