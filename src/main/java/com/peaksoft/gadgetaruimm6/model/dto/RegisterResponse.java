package com.peaksoft.gadgetaruimm6.model.dto;

import com.peaksoft.gadgetaruimm6.model.enums.Role;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegisterResponse {

     Long id;
     String firstName;
     String lastName;
     String email;
     String password;
     String phoneNumber;
     Role role;
    LocalDateTime createdDate;
}
