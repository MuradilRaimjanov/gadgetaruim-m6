package com.peaksoft.gadgetaruimm6.model.dto.mapper.impl;


import com.peaksoft.gadgetaruimm6.model.dto.LoginResponse;
import org.springframework.stereotype.Component;

@Component
public class LoginMapper {

    public static LoginResponse mapToResponse(String token) {
        return LoginResponse.builder()
                .token(token)
                .build();
    }
}
