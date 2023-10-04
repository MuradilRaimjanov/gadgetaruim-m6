package com.peaksoft.gadgetaruimm6.contoller;

import com.peaksoft.gadgetaruimm6.config.jwt.JwtUtil;
import com.peaksoft.gadgetaruimm6.model.dto.LoginRequest;
import com.peaksoft.gadgetaruimm6.model.dto.LoginResponse;
import com.peaksoft.gadgetaruimm6.model.dto.RegisterRequest;
import com.peaksoft.gadgetaruimm6.model.dto.RegisterResponse;
import com.peaksoft.gadgetaruimm6.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    private final JwtUtil util;

    @PostMapping("/sing-up")
    public ResponseEntity<RegisterResponse> register(@RequestBody @Valid RegisterRequest request) {
        return new ResponseEntity<>(authService.register(request), HttpStatus.OK);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<LoginResponse> signIn(@RequestBody LoginRequest request) {
        if(request == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(authService.authentication(request),HttpStatus.OK);
    }

    @GetMapping("/get")
    public String getUsername(@RequestParam String token){
        return util.extractUserName(token);
    }


}
