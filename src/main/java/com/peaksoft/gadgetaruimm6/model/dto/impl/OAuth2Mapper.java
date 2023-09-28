package com.peaksoft.gadgetaruimm6.model.dto.impl;

import com.peaksoft.gadgetaruimm6.model.dto.Mapper;
import com.peaksoft.gadgetaruimm6.model.dto.UserResponse;
import com.peaksoft.gadgetaruimm6.model.entity.Role;
import com.peaksoft.gadgetaruimm6.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class OAuth2Mapper implements Mapper<User, User, UserResponse> {

    @Override
    public User mapToEntity(User userRequest) {
        return null;
    }

    @Override
    public UserResponse mapToResponse(User entity) {
        return UserResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .created(entity.getCreated())
                .roleName(entity.getRoles().stream().map(Role::getRole).toString())
                .build();
    }
}