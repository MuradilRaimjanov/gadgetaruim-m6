package com.peaksoft.gadgetaruimm6.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    String email;
    String password;
}
