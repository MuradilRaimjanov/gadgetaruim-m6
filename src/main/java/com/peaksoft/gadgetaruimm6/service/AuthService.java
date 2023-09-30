package com.peaksoft.gadgetaruimm6.service;

import com.peaksoft.gadgetaruimm6.config.jwt.JwtUtil;
import com.peaksoft.gadgetaruimm6.model.dto.LoginRequest;
import com.peaksoft.gadgetaruimm6.model.dto.LoginResponse;
import com.peaksoft.gadgetaruimm6.model.dto.RegisterRequest;
import com.peaksoft.gadgetaruimm6.model.dto.RegisterResponse;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.impl.LoginMapper;
import com.peaksoft.gadgetaruimm6.model.dto.mapper.impl.UserMapper;
import com.peaksoft.gadgetaruimm6.model.entity.User;
import com.peaksoft.gadgetaruimm6.model.enums.Role;
import com.peaksoft.gadgetaruimm6.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthService {

    UserRepository userRepository;
    UserMapper userMapper;
    AuthenticationManager authenticationManager;
    JwtUtil jwtUtil;

    public RegisterResponse register(RegisterRequest registerRequest) {
        User user = userMapper.mapToEntity(registerRequest);
        user.setPassword(user.getPassword());
        user.setRole(Role.ROLE_USER);
        userRepository.save(user);
        return userMapper.mapToResponse(user);
    }

    public LoginResponse authentication(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail());
        var jwt = jwtUtil.generateToken(user);
        return LoginMapper.mapToResponse(jwt,user);
    }

}