package com.peaksoft.gadgetaruimm6.model.dto;

import com.peaksoft.gadgetaruimm6.model.enums.Role;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.ResponseEntity;

@Data
@Builder
public class LoginResponse {
    String token;
    Role role;
    String email;
    ResponseEntity<String> message;

    public LoginResponse(String token, Role role, String email) {
        this.token = token;
        this.role = role;
        this.email = email;
    }

    public LoginResponse(ResponseEntity<String> message) {
        this.message = message;
    }
}
