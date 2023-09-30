package com.peaksoft.gadgetaruimm6.model.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
public class LoginRequest {
    String email;
    String password;
}
