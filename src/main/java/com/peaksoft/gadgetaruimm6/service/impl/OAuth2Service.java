package com.peaksoft.gadgetaruimm6.service.impl;

import com.peaksoft.gadgetaruimm6.model.dto.UserResponse;
import com.peaksoft.gadgetaruimm6.model.dto.impl.OAuth2Mapper;
import com.peaksoft.gadgetaruimm6.model.entity.User;
import com.peaksoft.gadgetaruimm6.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OAuth2Service {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    OAuth2Mapper OAuth2Mapper;

    public UserResponse save(OAuth2AuthenticationToken auth2AuthenticationToken) {
        Map<String, Object> userGoogle = auth2AuthenticationToken.getPrincipal().getAttributes();
        User user = new User();
        String[] fullName = userGoogle.get("name").toString().split(" ");
        user.setName(fullName[0]);
        user.setLastName(fullName[1]);
        user.setEmail((String) userGoogle.get("email"));
        user.setCreated(LocalDateTime.now());
        user.setPassword(passwordEncoder.encode(userGoogle.get("name").toString()));

        userRepository.save(user);
        return OAuth2Mapper.mapToResponse(user);
    }
}
