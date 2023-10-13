package com.peaksoft.gadgetaruimm6.model.dto.mapper.impl;


import com.peaksoft.gadgetaruimm6.model.dto.LoginResponse;
import com.peaksoft.gadgetaruimm6.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class LoginMapper {

    public static LoginResponse mapToResponse(String token, User user) {

        return LoginResponse.builder()
                .email(user.getEmail())
                .token(token)
                .build();
    }
}
