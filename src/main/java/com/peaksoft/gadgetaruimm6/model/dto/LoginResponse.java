package com.peaksoft.gadgetaruimm6.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
    String token;
    String email;
}
