package com.peaksoft.gadgetaruimm6.contoller;


import com.peaksoft.gadgetaruimm6.model.dto.UserResponse;
import com.peaksoft.gadgetaruimm6.service.impl.OAuth2Service;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OAuth2Controller {

    OAuth2Service userService;

    @GetMapping("/sing-in")
    public UserResponse registration(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        return userService.save(oAuth2AuthenticationToken);
    }
}
