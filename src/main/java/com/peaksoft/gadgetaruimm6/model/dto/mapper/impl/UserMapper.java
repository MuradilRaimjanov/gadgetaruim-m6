package com.peaksoft.gadgetaruimm6.model.dto.mapper.impl;

import com.peaksoft.gadgetaruimm6.model.dto.RegisterRequest;
import com.peaksoft.gadgetaruimm6.model.dto.RegisterResponse;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.Mapper;
import com.peaksoft.gadgetaruimm6.model.entity.User;
import com.peaksoft.gadgetaruimm6.model.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class UserMapper implements Mapper<RegisterRequest, User, RegisterResponse> {
    @Override
    public User mapToEntity(RegisterRequest registerRequest) {
        return User.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .password(registerRequest.getPassword())
                .phoneNumber(registerRequest.getPhoneNumber())
                .build();
    }

    @Override
    public RegisterResponse mapToResponse(User user) {
        return RegisterResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .roleName(user.getRoles().stream().map(Role::getRole).toString())
                .createdDate(LocalDate.from(LocalDate.now().atStartOfDay()))
                .build();
    }
}
