package com.peaksoft.gadgetaruimm6.contoller;

import com.peaksoft.gadgetaruimm6.model.dto.LoginRequest;
import com.peaksoft.gadgetaruimm6.model.dto.RegisterRequest;
import com.peaksoft.gadgetaruimm6.model.dto.RegisterResponse;
import com.peaksoft.gadgetaruimm6.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@Tag(name = "Authentication controller ")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sing-up")
    @Operation(description = "This is method for registration")
    public ResponseEntity<RegisterResponse> register(@RequestBody @Valid RegisterRequest request) {
        System.out.println("Hello controller");
        System.out.println(request.getPhoneNumber());
        return new ResponseEntity<>(authService.register(request), HttpStatus.OK);
    }

    @PostMapping("/sign-in")
    @Operation(description = "This is method for authentication")
    public ResponseEntity<?> signIn(@RequestBody LoginRequest request) {
        return new ResponseEntity<>(authService.authentication(request), HttpStatus.OK);
    }

    @PostMapping("/forgot-password")
    @Operation(description = "This method implements the forgotten password function using email")
    public ResponseEntity<?> forgotPassword(@RequestParam String email) {
        try {
            authService.forgotPassword(email);
        } catch (Exception e) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("Email sent successfully", HttpStatus.OK);
    }

    @PostMapping("/reset-password")
    @Operation(description = "Using this method we reset the password")
    public ResponseEntity<?> presetPassword(@RequestParam String password, @RequestParam("token") String token) {
        try {
            authService.resetPassword(password, token);
        } catch (Exception e) {
            return new ResponseEntity<>("Token invalid", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Password updated", HttpStatus.OK);
    }
}







