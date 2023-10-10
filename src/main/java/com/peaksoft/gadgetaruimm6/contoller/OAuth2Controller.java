package com.peaksoft.gadgetaruimm6.contoller;


import com.peaksoft.gadgetaruimm6.model.dto.UserResponse;
import com.peaksoft.gadgetaruimm6.service.impl.OAuth2Service;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth2")
@Tag(name="o authorization2 controller")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OAuth2Controller {

    OAuth2Service userService;

    @GetMapping("/sign-up")
    @Operation(description = "this method for registering with Google ")
    public UserResponse registration(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        return userService.save(oAuth2AuthenticationToken);
    }
}
