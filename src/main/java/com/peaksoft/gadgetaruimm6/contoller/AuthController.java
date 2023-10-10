package com.peaksoft.gadgetaruimm6.contoller;

import com.peaksoft.gadgetaruimm6.model.dto.*;
import com.peaksoft.gadgetaruimm6.model.entity.User;
import com.peaksoft.gadgetaruimm6.repository.UserRepository;
import com.peaksoft.gadgetaruimm6.service.AuthService;
import com.peaksoft.gadgetaruimm6.service.impl.EmailServiceImpl;
import com.peaksoft.gadgetaruimm6.service.impl.UserDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final UserDetailsService userDetailsService;
    private final UserRepository userRepository;
    private final EmailServiceImpl emailService;
    private final PasswordEncoder encoder;


    @PostMapping("/sing-up")
    public ResponseEntity<RegisterResponse> register(@RequestBody @Valid RegisterRequest request) {
        return new ResponseEntity<>(authService.register(request), HttpStatus.OK);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<LoginResponse> signIn(@RequestBody LoginRequest request) {
        if (request == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(authService.authentication(request), HttpStatus.OK);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassoword(@RequestBody ForgotPasswordRequest request){
        User user = userRepository.findByEmail(request.getEmail());
        String otp = authService.generateOtp();
        if(user != null){
            emailService.sendCodeByMail(request.getEmail(),otp);
            user.setOtp(otp);
            user.setOtpGeneratedTime(LocalDateTime.now());
            userRepository.save(user);
        } else {
            return new ResponseEntity<>("Please regenerate code and try again",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Code verified you can login",HttpStatus.OK);
    }
    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequest request){
        String email = request.getEmail();
        User user = userRepository.findByEmail(email);
        if(user.getOtp().equals(request.getOtp()) &&
                Duration.between(user.getOtpGeneratedTime(),LocalDateTime.now()).getSeconds() < (3* 60)){
            user.setPassword(encoder.encode(request.getNewPassword()));
            userRepository.save(user);
            return new ResponseEntity<>("Password Change Successfully",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("The code is incorrect",HttpStatus.BAD_REQUEST);
        }


    }











}
