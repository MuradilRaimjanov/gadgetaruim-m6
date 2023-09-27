package com.peaksoft.gadgetaruimm6.service;

import com.peaksoft.gadgetaruimm6.model.dto.RegisterRequest;
import com.peaksoft.gadgetaruimm6.model.dto.RegisterResponse;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.impl.UserMapper;
import com.peaksoft.gadgetaruimm6.model.entity.User;
import com.peaksoft.gadgetaruimm6.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public RegisterResponse register( RegisterRequest registerRequest) {
        User user = userMapper.mapToEntity(registerRequest);
        user.setPassword(user.getPassword());
        userRepository.save(user);
        return userMapper.mapToResponse(user);
    }


}