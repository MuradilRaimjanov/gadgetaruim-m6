package com.peaksoft.gadgetaruimm6.contoller;

import com.peaksoft.gadgetaruimm6.model.dto.LoginRequest;
import com.peaksoft.gadgetaruimm6.model.dto.LoginResponse;
import com.peaksoft.gadgetaruimm6.model.dto.RegisterRequest;
import com.peaksoft.gadgetaruimm6.model.dto.RegisterResponse;
import com.peaksoft.gadgetaruimm6.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@Tag(name = "Authorization controller")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up")
    @Operation(description = "This method  for registration ")
    public ResponseEntity<RegisterResponse> register(@RequestBody @Valid RegisterRequest request) {
        return new ResponseEntity<>(authService.register(request), HttpStatus.OK);
    }

    @PostMapping("/sign-in")
    @Operation(description = "This method is for authentication ")
    public ResponseEntity<LoginResponse> signIn(@RequestBody LoginRequest request) {
        if(request == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(authService.authentication(request),HttpStatus.OK);
    }


}
