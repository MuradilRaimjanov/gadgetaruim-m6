package com.peaksoft.gadgetaruimm6.model.dto;

import com.peaksoft.gadgetaruimm6.model.enums.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
    String token;
    String email;

    public LoginResponse(String token, String email) {
        this.token = token;
        this.email = email;
    }

}
